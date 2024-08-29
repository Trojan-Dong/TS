package test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: HisDataHandleServiceImpl
 * @author: jiangtao
 * @describe: 借记卡与银联清算历史交易账务处理
 * @date: 2024/03/09
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HisSettlementDataHandleReq {

    private String startDate;

    private String endDate;

    private String type;
}
