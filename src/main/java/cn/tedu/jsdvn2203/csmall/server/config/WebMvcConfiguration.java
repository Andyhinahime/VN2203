package cn.tedu.jsdvn2203.csmall.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 配置被跨域路徑(具體地址)
                .allowedOriginPatterns("*")  // 項目的所有接口支持跨域
                .allowedHeaders("*")         // 屬性表示允許的請求頭有哪些
                .allowedMethods("*")         // 請求方式:post/get/put/delete
                .allowCredentials(true)      // 是否允許請求帶有驗證信息
                .maxAge(3600);               // 允許跨域的時間(單位：秒)
    }
}










