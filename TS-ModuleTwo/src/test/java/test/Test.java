package test;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Test test=new Test();
        test.testToString(null);
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
