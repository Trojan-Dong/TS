package mapstruct;

public class SourceObject {
    private String quotaCode;
    
    private Long id;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getQuotaCode() {
        return quotaCode;
    }
    
    public void setQuotaCode(String quotaCode) {
        this.quotaCode = quotaCode;
    }
}
