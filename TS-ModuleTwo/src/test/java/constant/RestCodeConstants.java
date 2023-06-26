package constant;

public final class RestCodeConstants {
    
    /**
     * 默认的接口成功码
     */
    public static final String DEFAULT_SUCCESS_CODE = "0000";
    
    /**
     * 默认的接口成功返回信息
     */
    public static final String DEFAULT_SUCCESS_MSG = "success";
    
    /**
     * 默认的接口失败码
     */
    public static final String DEFAULT_ERROR_CODE = "0001";
    
    /**
     * 默认的参数校验错误
     */
    public static final String DEFAULT_CONSTRAINT_ERROR_CODE = "0002";
    
    /**
     * 系统异常时默认返回的错误信息
     */
    public static final String DEFAULT_ERROR_MSG = "系统处理异常，请稍后重试!";
    
    /**
     * 当被限流时的返回信息
     */
    public static final String DEFAULT_REST_URL_BLOCK_MSG = "系统繁忙，请稍后再试！";
    
    /**
     * 当被限流时的返回错误描述
     */
    public static final String DEFAULT_REST_URL_BLOCK_ERROR_DESC = "当前接口已被限流！";
    
    private RestCodeConstants() {
    }
    
}
