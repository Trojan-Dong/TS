package xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ClassName: EventNotificationAdvanceTransactionDTO
 * @author: jinzhilong
 * @describe: EventNotificationAdvanceTransactionDTO
 * @date: 2021/9/28
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventNotificationAdvanceTransactionDTO {
    
    /**
     * N 40
     * Unique ID assigned to the Push Notification Request
     */
    private String notificationEventId;
    
    /**
     * N 11
     * Transaction Identifier
     */
    private String transactionId;
    
    /**
     * N4
     * Message Type Identifier Refer to Appendix ISO Message Types to see the possible values for this field
     */
    private String messageType;
    
    /**
     * Date
     * Date of the Transaction Date Format: YYYY-MM-DD
     */
    private String date;
    
    /**
     * Time
     * Time of Transaction Date Format: HH:MM:SS
     */
    private String time;
    
    /**
     * Strg 20
     * Acquirer’s Reference Number
     */
    private String arn;
    
    /**
     * cardAcceptor 对象信息
     */
    private EventNotificationAdvanceTransactionCardAcceptorDTO cardAcceptor;
    
    /**
     * AN2
     * Transaction Type Identifier
     * Refer to Appendix Transaction Type Codes
     * to see the possible values for this field
     */
    private String transactionType;
    
    /**
     * Strg 120
     * Service applied on Transaction
     */
    private String service;
    
    /**
     * N 10, 2
     * The transaction amount requested by the
     * merchant
     */
    private BigDecimal requestedAmount;
    
    /**
     * AN 3
     * Currency of the Requested Amount
     */
    private String requestedAmountCurrency;
    
    /**
     * N 10, 2
     * Amount posted on Card Account
     * If the amount is to be debited from the Card
     * Account then it will be represented with -ve
     * sign (i.e., -100.00)
     */
    private String transactionAmount;
    
    /**
     * AN 3
     * ISO Currency Code of Card Account
     */
    private String transactionCurrency;
    
    /**
     * AN 2
     * Status of Transaction
     * Refer to Appendix Transaction Response
     * Codes to see the possible values for this
     * field
     */
    private String transactionResponseCode;
    
    /**
     * N 10, 2
     * The interchange fee charged from the
     * merchant.
     */
    private BigDecimal interchangeFee;
    
    /**
     * AN 3
     * Indicated how the PAN was captured.
     * Please refer to the network manual.
     */
    private String panEntryMode;
    
    /**
     * A1
     * Indicates whether the card was present in a
     * transaction or not.
     */
    private String cardPresent;
    
    /**
     * AN 16
     * For network transactions, it contains the
     * authorization code.
     * For ACH transactions, it contains the Return
     * Code (for ACH returns) or the Notification Of
     * Change (NOC) Code (in case a NOC is
     * received)
     */
    private String authorizationCode;
    
    /**
     * AN 80
     * A unique transaction reference provided by the
     * acquirer.
     */
    private String retrievalReferenceNo;
    
    /**
     * AN 24
     * A unique transaction reference provided by the
     * network.
     */
    private String systemTraceAuditNo;
    
    /**
     * AN 25
     * Identifies the network
     */
    private String networkId;
    
    /**
     * N 11
     * Identifier of the Original Transaction against
     * which this Transaction is Posted
     */
    private String originalTransId;
    
    /**
     * AN 30
     * A unique identifier assigned to the
     * transaction by Switch in case of network
     * transactions or assigned by i2c in case of
     * ACH transactions. The unique identifier
     * assigned to ACH transaction can be referred
     * as ACH transfer ID that can be used to
     * uniquely identify Bank to Card and Card to
     * Bank Transfers in the system.
     */
    private String transferID;
    
    /**
     * AN 31
     * A unique i2c internal identifier for a bank
     * account definition in our system. Used in
     * ACH transfers.
     */
    private String bankAccountNumber;
    
    /**
     * Strg 255
     * A user friendly description, explaining the
     * purpose of the transaction.
     */
    private String transactionDescription;
    
    /**
     * Strg 40
     * Reserved for i2c use
     */
    private String externalTransReference;
    
    /**
     * Strg 40
     * Reserved for i2c use
     */
    private String externalUserReference;
    
    /**
     * AN 11
     * Reference number of the linked card account.
     */
    private String externalLinkedCardRefID;
    
    /**
     * Strg 255
     * Profile information of the linked card account.
     */
    private String externalLinkedCardProfileSet1;
    
    /**
     * Strg 255
     * Profile information of the linked card account.
     */
    private String externalLinkedCardProfileSet2;
    
    /**
     * AN 3
     * The Primary Account Number sequence number
     */
    private String panSequenceNo;
    
    /**
     * AN 20
     * Identifies the invoked fraud parameter
     */
    private String fraudParameter;
    
    /**
     * Date
     * Network Settlement Date
     */
    private String settlementDate;
    
    /**
     * Type of payment (1, 2, 3)
     * 1 (Rebate Load)
     * 2 (Personal Loads)
     * 3 (Other Network Loads)
     */
    private String paymentType;
}
