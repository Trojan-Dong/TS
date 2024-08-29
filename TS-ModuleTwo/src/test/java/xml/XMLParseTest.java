package xml;

import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Objects;

@Slf4j
public class XMLParseTest {
    
    public static void main(String[] args) {
        EventNotificationAdvanceReq req=new EventNotificationAdvanceReq();
        String xmlStr = "{\"Header\":{\"Id\":\"cibAcq471\",\"UserId\":\"cibAcq\",\"Password\":\"Cib@2022!\",\"MessageCreationDateTime\":\"2024-07-04 19:22:16\"},\"Transaction\":{\"NotificationEventId\":\"64540\",\"TransactionId\":\"65566\",\"MessageType\":\"0200\",\"Date\":\"2024-07-04\",\"Time\":\"22:21:35\",\"CardAcceptor\":{\"AcquirerId\":\"4105840\",\"MerchantCode\":\"410584060110001\",\"MerchantNameAndLocation\":\"PingAn Bank                             156\",\"MCC\":\"6011\",\"DeviceId\":\"71000145\",\"DeviceType\":\"A\",\"LocalDateTime\":\"2024-07-05 10:21:35\"},\"TransactionType\":\"01\",\"Service\":\"ATM Wdr Intl Multi Curr\",\"RequestedAmount\":\"-3000\",\"RequestedAmountCurrency\":\"CNY\",\"TransactionAmount\":\"-415.98\",\"TransactionCurrency\":\"USD\",\"TransactionResponseCode\":\"00\",\"PANEntryMode\":\"051\",\"CardPresent\":\"Y\",\"AuthorizationCode\":\"LKB0C9\",\"RetrievalReferenceNo\":\"000145406015\",\"TransferID\":\"12362869660110141058\",\"BankAccountNumber\":\"0\",\"TransactionDescription\":\"ATM Withdrawal International (with currency conversion) [China, Yuan Renminbi: 3000.0], Fx @0.138659\"},\"Card\":{\"CardNo\":\"6264254388138696\",\"CardProgramID\":\"cbi-corporate-dbt-88\",\"CardReferenceID\":\"471001098323\",\"PrimaryCardNo\":\"62T5177143123628696\",\"PrimaryCardReferenceID\":\"471001098323\",\"CustomerId\":\"471000000000010983\",\"AvailableBalance\":\"4366.35\",\"LedgerBalance\":\"4366.35\",\"CardStatus\":\"B\",\"CountryCode\":\"USA\"}}";
//        xmlStr = xmlStr.replaceAll("request:", "");
//        xmlStr = xmlStr.replaceAll("<request>", "");
//        xmlStr = xmlStr.replaceAll("</request>", "");
//        //替换xmlStr中的\"为"
//        xmlStr = xmlStr.replaceAll("\\\\\"", "\"");
//        System.out.println(xmlStr);
//        Document document = XmlUtil.parseXml(xmlStr);
//        //        获取document中NotifyEventAdvance节点下的request节点，并打印节点的值
//        NodeList nodeList = document.getChildNodes();
//
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node node = nodeList.item(i);
//            if (Objects.equals(node.getNodeName(), "NotifyEventAdvance")) {
//                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(XmlUtil.xmlToMap(node)));
//                req = JSONObject.parseObject(jsonObject.get("NotifyEventAdvance").toString(),
//                        EventNotificationAdvanceReq.class);
//            }
//        }
        req = JSONObject.parseObject(xmlStr,EventNotificationAdvanceReq.class);
        log.info(req.getTransaction().getTransactionCurrency());
        log.info(req.getTransaction().getRequestedAmountCurrency());
        log.info("转换后的请求参数,EventNotificationAdvanceReq:{}", JSON.toJSONString(req));
    }
}
