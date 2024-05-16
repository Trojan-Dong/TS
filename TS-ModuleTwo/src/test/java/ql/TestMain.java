package ql;

import com.alibaba.fastjson.JSON;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import test.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestMain {
    
    private static final ExpressRunner runner = new ExpressRunner();
    
    public static boolean applyFactoryCondition(boolean chargeFlag, boolean isChargeable, String conditions) {
        if (conditions == null) {
            return chargeFlag;
        }
        
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("chargeFlag", chargeFlag);
        context.put("isChargeable", isChargeable);
        // 根据工厂返回的条件构建QLExpress表达式
        String express = "chargeFlag " + conditions + " isChargeable";
        try {
            return (boolean) runner.execute(express, context, null, true, false);
        } catch (Exception e) {
            // 处理执行异常，例如条件不合法等
            throw new RuntimeException("Failed to execute QLExpress: " + express, e);
        }
    }
    
    
    private static boolean matchRules(String express, String service,String currency, BigDecimal amount)
            throws Exception {
        //service = POS Signature Purchase 或  POS PIN Purchase 或  amount *0.01<0.05  根据描述生成 ql表达式
        String factory_conditions = "OR";
        
        express="(serviceType == 'POS Signature Purchase' || serviceType == 'POS PIN Purchase') && amount * 0.01 <= 0.05";
        ExpressRunner runner = new ExpressRunner();
        String qlScript = runner.getExpressResourceLoader().loadExpress(express);
        // 构建上下文环境，将请求对象的属性映射到表达式中
        DefaultContext<String,Object> context =new DefaultContext<>();
        context.put("service",service);
        context.put("currency",currency);
        context.put("amount",amount);
        context.put("rate",0.01);
        
        try {
            // 执行表达式并获取结果
            Boolean result = (Boolean) runner.execute(qlScript, context, null, true, false);
            return result != null && result;
        } catch (Exception e) {
            return false;
        }
    }
    public String[] testMethod(String tar){
      String[] list=new String[]{"a","b","c","d"};
        for (String str:list){
            if (Objects.equals(tar,str)){
                return new String[]{str};
            }
        }
        return list;
        
    }
    public static void main(String[] args) {
//        System.out.println(applyFactoryCondition(false, false, "and"));
//        System.out.println(applyFactoryCondition(false, true, "and"));
//        System.out.println(applyFactoryCondition(true, true, "and"));
        TestMain testMain=new TestMain();
        System.out.println(JSON.toJSONString(testMain.testMethod("b")));
    
    
    }
}
