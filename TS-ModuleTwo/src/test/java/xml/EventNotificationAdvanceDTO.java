package xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: EventNotificationAdvanceDTO
 * @author: jinzhilong
 * @describe: EventNotificationAdvanceDTO
 * @date: 2021/9/28
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventNotificationAdvanceDTO {
    
    /**
     * 请求头信息
     */
    private PushApiHeaderDTO header;
    
    /**
     * 事件通知交易信息
     */
    private EventNotificationAdvanceTransactionDTO transaction;
    
    private EventNotificationAdvanceTransactionCardDTO card;
}
