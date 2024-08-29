package xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: HealthCheckHeaderDTO
 * @author: jinzhilong
 * @describe: HealthCheckHeaderDTO
 * @date: 2021/9/26
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PushApiHeaderDTO {
    
    /**
     * AN 11
     * Acquirer Identification Code assigned to MCP Application by Client
     */

    private String id;
    
    /**
     * AN 20
     * User ID assigned to MCP Application by Client
     */
    private String userId;
    
    /**
     * Strg 80
     * Password Code assigned to MCP Application by Client
     */
    private String password;
    
    /**
     * DT
     * Date and time of the device sending the request Date format: YYYY-MM-DDTHH:MM:SS
     */
    private String messageCreationDateTime;
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PushApiHeaderDTO)) {
            return false;
        }
        PushApiHeaderDTO dto = (PushApiHeaderDTO) obj;
        if (!this.id.equals(dto.getId())) {
            return false;
        }
        if (!this.password.equals(dto.getPassword())) {
            return false;
        }
        if (!this.userId.equals(dto.getUserId())) {
            return false;
        }
        return true;
    }
}
