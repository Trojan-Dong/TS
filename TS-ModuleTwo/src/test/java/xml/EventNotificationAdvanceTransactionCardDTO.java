package xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ClassName: EventNotificationAdvanceTransactionCardDTO
 * @author: jinzhilong
 * @describe: EventNotificationAdvanceTransactionCardDTO
 * @date: 2021/9/28
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventNotificationAdvanceTransactionCardDTO {
    
    /**
     * N 19
     * Card Account Number
     * This tag will only be available for PCI
     * certified clients
     */
    private String cardNo;
    
    /**
     * Strg 20
     * ID of the Card Program
     */
    private String cardProgramId;
    
    /**
     * N 15
     * Reference Number which uniquely identifies
     * this Card Account
     */
    private String cardReferenceId;
    
    /**
     * N 19
     * Number of the Primary Account against
     * which this Card is Issue
     * This tag will only be available for PCI
     * certified clients
     */
    private String primaryCardNo;
    
    /**
     * N 15
     * Reference Number which uniquely identifies
     * a (primary) card
     */
    private String primaryCardReferenceID;
    
    /**
     * Strg 20
     * Cardholder ID to whom Card Account is
     * Issue/Registered
     */
    private String customerId;
    
    /**
     * Strg 25
     * Cardholder's Member ID
     */
    private String memberId;
    
    /**
     * N 10, 2
     * Card Account Balance
     * If the available balance on Card Account is
     * is in negative the it will be represented with -
     * ve sign (i.e., -8.60)
     */
    private BigDecimal availableBalance;
    
    /**
     * N 10, 2
     * Card Account Ledger Balance
     * If the ledger balance on Card Account is is in
     * negative the it will be represented with -ve
     * sign (i.e., -8.60)
     */
    private BigDecimal ledgerBalance;
    
    /**
     * Char
     * Status Code of Card Account.
     * Refer to the Appendix B: Card Status Codes
     */
    private String cardStatus;
    
    /**
     * Strg 26
     * Cardholder's First Name
     */
    private String firstName;
    
    /**
     * Strg 26
     * Cardholder's Last Name
     */
    private String lastName;
    
    /**
     * Strg 30
     * Cardholder's Address (Line 1)
     */
    private String addressLine1;
    
    /**
     * Strg 30
     * Cardholder's Address (Line 2)
     */
    private String addressLine2;
    
    /**
     * AN 40
     * Cardholder's City
     */
    private String city;
    
    /**
     * AN 15
     * Cardholder's State
     */
    private String state;
    
    /**
     * Strg 20
     * Cardholder's Postal/Zip Code
     */
    private String postalCode;
    
    /**
     * AN 3
     * Cardholder's Country Code
     */
    private String countryCode;
    
    /**
     * N 15
     * Cardholder's Cell Phone No
     */
    private String cellNo;
    
    /**
     * Strg 100
     * Cardholder's E-mail address
     */
    private String email;
    
    /**
     * AN 40
     * Source card reference number
     */
    private String sourceCardReferenceNo;
    
    /**
     * AN 19
     * Source card number
     */
    private String sourceCardNo;
}
