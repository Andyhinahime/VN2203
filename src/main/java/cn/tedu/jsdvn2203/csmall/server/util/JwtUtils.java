package cn.tedu.jsdvn2203.csmall.server.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtils {
    /**
     * 簽名密鑰
     */
    private static final String SECRET_KEY = "himehina12809";
    /**
     * JWT過期時間:以分鐘為單位
     */
    private static final long EXPIRATION_IN_MINUTE = 7 * 24 * 60;

    /**
     * 私有化構造方法,避免外部隨意創建對象
     * */
    private JwtUtils() {
    }

    //解析JWT
    public static Claims parse(String jwt){
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt).getBody();
    }
}
