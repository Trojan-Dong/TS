package xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName: EventNotificationAdvanceTransactionCardAcceptorDTO
 * @author: jinzhilong
 * @describe: EventNotificationAdvanceTransactionCardAcceptorDTO
 * @date: 2021/9/28
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventNotificationAdvanceTransactionCardAcceptorDTO {
    
    
    /**
     * Strg 44
     * Acquirer Identifier
     */
    private String acquirerId;
    
    /**
     * Strg 15
     * Merchant Identifier
     */
    private String merchantCode;
    
    /**
     * AN 40
     * erchant’s name and locationCharacters from:
     * •1-23 contain the merchant’s name
     * •24-36 contain the city name
     * •37-38 contain state code
     * •39-40 contain country code
     */

    private String nameAndLocation;
    
    /**
     * AN 40
     * erchant’s name and locationCharacters from:
     * •1-23 contain the merchant’s name
     * •24-36 contain the city name
     * •37-38 contain state code
     * •39-40 contain country code
     */
 
    private String merchantNameAndLocation;
    
    /**
     * AN 40
     * Merchant's city coming from the 'Name And
     * Location' string
     */
    private String merchantCity;
    
    /**
     * AN 15
     * Merchant's state coming from the 'Name
     * And Location' string
     */
    private String merchantState;
    
    /**
     * Strg 20
     * Merchant's zip code
     */
    private String merchantZipCode;
    
    /**
     * N 4
     * Merchant Category Code
     */
    private Long mcc;
    
    /**
     * Strg 8
     * Merchant Device Identifier
     */
    private String deviceId;
    
    /**
     * Char
     * Device Type Identifier
     * Refer to Appendix Device Types to see the
     * possible values for this field
     */
    private String deviceType;
    
    /**
     * DT
     * Date and Time of the Device from which
     * Transaction was Received
     * Date Format: YYYY-MM-DDTHH:MM:SS
     */
    private Date localDateTime;
}
