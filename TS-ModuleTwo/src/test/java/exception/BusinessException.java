package exception;

import constant.RestCodeConstants;
import org.apache.commons.lang3.StringUtils;

public class BusinessException  extends RuntimeException  {
    /**
     * 返回错误编码
     */
    private String retCode;
    
    /**
     * 返回的错误显示信息
     */
    private String retMsg;
    
    /**
     * 返回的错误详细信息
     */
    private String errorDesc;
    
    public BusinessException(String retMsg) {
        super(retMsg);
        this.retCode = RestCodeConstants.DEFAULT_ERROR_CODE;
        this.retMsg = retMsg;
    }
    
    public BusinessException(String retMsg, Exception e) {
        super(e);
        this.retCode = RestCodeConstants.DEFAULT_ERROR_CODE;
        this.retMsg = retMsg;
        this.errorDesc = e.getMessage();
    }
    
    public BusinessException(String retCode, String retMsg) {
        super(retMsg);
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    
    public BusinessException(String retCode, String retMsg, Exception e) {
        super(e);
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.errorDesc = e.getMessage();
    }
    
    public BusinessException(String retCode, String retMsg, String errorDesc) {
        super(StringUtils.defaultIfBlank(errorDesc, retMsg));
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.errorDesc = errorDesc;
    }
    
    public String getRetCode() {
        return retCode;
    }
    
    public String getRetMsg() {
        return retMsg;
    }
    
    public String getErrorDesc() {
        return errorDesc;
    }
    
    @Override
    public String toString() {
        return "[retCode: " + retCode + "],[retMsg: " + retMsg + "],[errorDesc: " + errorDesc + "]";
    }
}
