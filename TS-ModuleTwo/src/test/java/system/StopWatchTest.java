package system;

import org.springframework.util.StopWatch;
import utils.MathUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StopWatchTest {
    
    public static void main(String[] args) {
        //        StopWatch stopWatch=new StopWatch("test");
        //        stopWatch.start("t1");
        //        int sum=0;
        //        for (int i=0;i<10*60*60*1000;i++){
        //            sum+=i;
        //        }
        //        stopWatch.stop();
        //        System.out.println("time:"+stopWatch.getLastTaskInfo().getTaskName()+stopWatch.getLastTaskTimeNanos
        //        ()+","+sum);
        //        stopWatch.start("t2");
        //        stopWatch.stop();
        //        System.out.println(stopWatch.getTotalTimeMillis());
        
        //        HashMap<String, String> map = new HashMap<>();
        //        String str = map.get("1");
        //        System.out.println(map.containsKey("1"));
//        Test test = new Test();
//        System.out.println(MathUtils.add(test.getBig(), BigDecimal.ONE));
//        System.out.println(MathUtils.subtract(test.getBig(), BigDecimal.ONE));
//        System.out.println(MathUtils.multiply(test.getBig(), BigDecimal.ONE));
//        System.out.println(MathUtils.divide(BigDecimal.ONE, test.getBig()));
        //        System.out.println(map.containsKey(null));
        //        System.out.println(str);
//        Map<String,String> map=new HashMap();
//        map.put("str","saa");
//        map.put("QW","1");
//        System.out.println(map.get("str"));
//        System.out.println(map.get("STR"));
//        System.out.println(map.get("QW"));
//        System.out.println(map.get("qw"));
        System.out.println(new BigDecimal("-121.111111").scale());
        
    }
}
