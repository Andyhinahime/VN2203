package cn.tedu.jsdvn2203.csmall.server.filter;

import cn.tedu.jsdvn2203.csmall.server.security.LoginPrincipal;
import cn.tedu.jsdvn2203.csmall.server.util.JwtUtils;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static cn.tedu.jsdvn2203.csmall.server.web.ServiceCode.*;

@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.debug("執行到JwtAuthorizationFilter過濾器");
        SecurityContextHolder.getContext();

        //從消息頭獲取Jwt
        String jwt = request.getHeader("Authorization");
        log.debug("或取道的Jwt:{}",jwt);
        if(!StringUtils.hasText(jwt)){
            log.debug("請求頭中的Jwt數據是無效的,直接放行");
            filterChain.doFilter(request,response);
            return;
        }

        Claims claims = null;
        try {
            /* claims = Jwts.parser().setSigningKey("abcxyz123")
                    .parseClaimsJws(jwt).getBody();*/
            claims = JwtUtils.parse(jwt);
        } catch (ExpiredJwtException e) {
            log.debug("解析JWT失敗,JWT過期:{} , 錯誤訊息:{}", e.getClass().getName(), e.getMessage());
            String errorMessage = "登入過期,請重新登入,謝謝!";
            JsonResult jsonResult = JsonResult.fail(ERR_JWT_EXPIRED, errorMessage);
            String jsonResultString = JSON.toJSONString(jsonResult);
            response.setContentType("application/json;charset = UTF-8");
            response.getWriter().println(jsonResultString);
            return;
        } catch (MalformedJwtException e) {
            log.debug("解析JWT失敗 , JWT資料錯誤: 類名{} , 錯誤訊息:{}", e.getClass().getName(), e.getMessage());
            String errorMessage = "獲取登入訊息失敗,請重新登入";
            JsonResult jsonResult = JsonResult.fail(ERR_JWT_INVALID, errorMessage);
            String jsonResultString = JSON.toJSONString(jsonResult);
            response.setContentType("application/json ; charset = UTF-8");
            response.getWriter().println(jsonResultString);
            return;
        } catch (SignatureException e) {
            log.debug("解析JWT失敗,簽名錯誤 , 類名:{} , 錯誤訊息:{}",e.getClass().getName(),e.getMessage());
            String errorMessage = "獲取登入訊息失敗,請重新登入";
            JsonResult jsonResult = JsonResult.fail(ERR_JWT_INVALID, errorMessage);
            String jsonResultString = JSON.toJSONString(jsonResult);
            response.setContentType("application/json ; charset = UTF-8");
            response.getWriter().println(jsonResultString);
            return;
        } catch (Throwable e) {
            log.debug("解析JWT失敗,錯誤詳情=>類名:{},錯誤訊息:{}",e.getClass().getName(),e.getMessage());
            String errorMessage = "獲取登入訊息失敗,請重新登入";
            JsonResult jsonResult = JsonResult.fail(ERR_JWT_INVALID, errorMessage);
            String jsonResultString = JSON.toJSONString(jsonResult);
            response.setContentType("application/json ; charset = UTF-8");
            response.getWriter().println(jsonResultString);
            return;

        }

        Object id = claims.get("id");
        Object username = claims.get("username");
        log.debug("解析得到的id:{} , username:{}",id,username);

        LoginPrincipal loginPrincipal = new LoginPrincipal();
        loginPrincipal.setId(Long.parseLong(id.toString()));
        loginPrincipal.setUsername(username.toString());

        Object authoritiesString = claims.get("authorities");
        List<SimpleGrantedAuthority> authorities
                = JSON.parseArray(authoritiesString.toString(),SimpleGrantedAuthority.class);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(loginPrincipal, null, authorities);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        //放行
        filterChain.doFilter(request,response);
    }
}
