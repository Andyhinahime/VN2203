package cn.tedu.jsdvn2203.csmall.server.security;

import lombok.Data;

/**
 *  當前登入的當事人相關訊息
 */
@Data
public class LoginPrincipal {
    /**
     * 當前登入的用戶id
     */
    private Long id;
    /**
     * 當前登入的帳號
     */
    private String username;

}
