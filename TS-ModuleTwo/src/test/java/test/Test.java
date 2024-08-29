package test;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
public class Test {
    
    private BigDecimal a;
    
    public BigDecimal getA() {
        return a;
    }
    
    public void setA(BigDecimal a) {
        this.a = a;
    }
    
    public void testToString(Test test){
        System.out.println(JSONUtil.toJsonStr(test));
    }
    public static void main(String[] args) {
//        String reserved = "000501 15600 20100A";
//        System.out.println(StringUtils.lastIndexOfAny(reserved, "M","F"));
//        System.out.println(reserved.substring(0,StringUtils.lastIndexOfAny(reserved,"M", "F")+1));
//        System.out.println(reserved.substring(reserved.length() - 3, reserved.length() - 1));
//
//        for(int i=0;i<10;i++){
//            for (int j = 100;j<200;j++){
//                if (j==100){
//                    System.out.println(i);
//                    System.out.println(j);
//                    break;
//                }
//            }
//        }
//
    
        System.out.println(LocalDate.now().plusDays(1).getDayOfWeek().getValue());
        System.out.println(LocalDate.now().plusDays(2).getDayOfWeek().getValue());
        System.out.println(LocalDate.now().plusDays(3).getDayOfWeek().getValue());
        System.out.println(LocalDate.now().plusDays(4).getDayOfWeek().getValue());
        System.out.println(LocalDate.now().plusDays(5).getDayOfWeek().getValue());
        System.out.println(LocalDate.now().plusDays(6).getDayOfWeek().getValue());
        System.out.println(LocalDate.now().plusDays(7).getDayOfWeek().getValue());
//        // 获取保留字段
//        String reserved ="1 52800081011490700700F";
//        // 如果保留字段为空或仅包含空格，则直接返回
//        if (StringUtils.isBlank(reserved)) {
//            return;
//        }
//        // 去除保留字段两端的空格
//        reserved = reserved.trim();
//        // 查找最后一个"M"或"F"字符的位置，用于确定ECI的位置
//        int endIndex = StringUtils.lastIndexOfAny(reserved, "M", "F");
//        // 截取reserved，从第一个字符到最后一个M或F出现的位置
//        reserved = reserved.substring(0, endIndex);
//        // 如果没有找到"M"或"F"，或保留字段长度不足以包含ECI，则返回
//        if (endIndex == -1 || reserved.length() < 4) {
//            return;
//        }
//        // 提取最后2位作为ECI
//        String terminalType = reserved.substring(reserved.length() - 4,reserved.length() - 2);
//        // 判断ECI是否为"00"，以确定交易是通过POS机还是电子方式完成
//        boolean isPos = !StringUtils.equalsAny(terminalType,"07","08");
//
//        System.out.println(terminalType);
//        System.out.println(isPos);
        //        Test test=new Test();
//        test.testToString(null);
        //        System.out.println(!false && true);
        //        System.out.println(false && true);
        //        System.out.println(!false && false);
        //        System.out.println(!(false && false));
        //        System.out.println(false && false);
//        List<Test> list = new ArrayList<>();
//        System.out.println(Optional.of(list).get().size());
//        System.out.println(Optional.ofNullable(list).get().size());
//        int a=0;
//        List<Test> list1 = null;
//       Optional.ofNullable(list1).isPresent();
//        System.out.println(Optional.of(list1).get().size());
//        System.out.println(StringUtils.isEmpty(""));
//        String operationContent = String.format("%s,accNo:%,accName:%,currency:%s,amount:%s",
//               "type", "payerAccInfo.getAccNo()", "payerAccInfo.getAccName()",
//                "payerAccInfo.getAccCurrency()","req.getAmount()");
//        System.out.println(operationContent);
    }
}
