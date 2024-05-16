package fileParse;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisaSummaryReport {
    
    SummerySecond interchange;
    
    SummerySecond reimbursementFee;
    
    SummerySecond visaCharge;
    
    SummerySecond total;
    
    public VisaSummaryReport(JSONObject jsonObject) {
    }
}
