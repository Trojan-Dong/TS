package xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: EventNotificationAdvanceReq
 * @author: jinzhilong
 * @describe: EventNotificationAdvanceReq
 * @date: 2021/9/26
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventNotificationAdvanceReq {
    
    /**
     * 请求头信息
     */
    private PushApiHeaderDTO header;
    
    /**
     * 事件通知交易信息
     */
    private EventNotificationAdvanceTransactionDTO transaction;
    
    /**
     * 卡信息
     */
    private EventNotificationAdvanceTransactionCardDTO card;
}
