//import com.trojan.two.OneApp;
//import event.DemoEventOne;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = OneApp.class)
//@WebAppConfiguration
//public class TestMain implements ApplicationListener<DemoEventOne> {
//    @Autowired
//    ApplicationContext applicationContext;
//
//    @Test
//    public void testOne() {
//        applicationContext.publishEvent(new DemoEventOne(this, "msg"));
//        System.out.println(applicationContext.getClassLoader());
//    }
//
//    @Override
//    public void onApplicationEvent(DemoEventOne event) {
//        System.out.println(event.getMsg());
//    }
//}
