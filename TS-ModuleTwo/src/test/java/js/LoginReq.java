package js;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginReq {
    
    private String loginMethod;
    
    private String userAccount;
    
    private String userPassword;
    
    private String encoded;
}
