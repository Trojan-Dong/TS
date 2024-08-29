package fileParse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisaSummaryReport {
    
    SummerySecond interchange;
    
    SummerySecond reimbursementFee;
    
    SummerySecond visaCharge;
    
    SummerySecond total;
    
}
