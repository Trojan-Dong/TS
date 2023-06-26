package enumt;

public enum BalSumWayEnum {
    
    /**
     * NOT_ACTIVE未激活、 NORMAL正常、 FREEZE冻结、 CLOSE关户、 STOP止付
     */
    NOT_ACTIVE("NOT_ACTIVE", "未激活", "Not Active"),
    
    NORMAL("NORMAL", "正常", "Normal"),
    FREEZE("FREEZE", "冻结", "Freeze"),
    CLOSE("CLOSE", "关户", "Close"),
    STOP("STOP", "止付", "Stop"),
    LOCK("LOCK", "锁定", "Lock"),
    NO_RECEIVE_NO_PAY("NO_RECEIVE_NO_PAY", "不收不付", "No Receive No Pay"),
    ONLY_RECEIVE_NO_PAY("ONLY_RECEIVE_NO_PAY", "只收不付", "Only Receive No Pay"),
    NO_RECEIVE_ONLY_PAY("NO_RECEIVE_ONLY_PAY", "不收只付", "No Receive Only Pay");
    
    final private String code;
    
    final private String shortNameCn;
    
    final private String shortNameEn;
    
    BalSumWayEnum(String code, String shortNameCn, String shortNameEn) {
        this.code = code;
        this.shortNameCn = shortNameCn;
        this.shortNameEn = shortNameEn;
    }
}
