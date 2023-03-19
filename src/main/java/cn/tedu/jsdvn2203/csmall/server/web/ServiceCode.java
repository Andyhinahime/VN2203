package cn.tedu.jsdvn2203.csmall.server.web;

public class ServiceCode {
    /**
     * 成功
     */
    public static final int OK = 20000;
    /**
     * 錯誤:數據格式有問題
     */
    public static final int ERR_BAD_REQUEST = 40000;
    /**
     * 錯誤:數據不存在
     */
    public static final int ERR_NOT_FOUND = 40400;
    /**
     * 错误：JWT数据错误，可能被恶意篡改
     */
    public static final int ERR_JWT_INVALID = 40001;
    /**
     * 错误：JWT过期
     */
    public static final int ERR_JWT_EXPIRED = 40300;
    /**
     * 錯誤:資料重複
     */
    public static final int ERR_CONFLICT = 40900;
    /**
     * 錯誤:插入資料失敗
     */
    public static final int ERR_INSERT = 50000;
    /**
     * 錯誤:刪除資料失敗
     */
    public static final int ERR_DELETE = 50001;
    /**
     * 錯誤:編輯資料失敗
     */
    public static final int ERR_UPDATE = 50002;
    /**
     * 錯誤:未處理的異常
     */
    public static final int ERR_UNKNOWN = 59999;


}
