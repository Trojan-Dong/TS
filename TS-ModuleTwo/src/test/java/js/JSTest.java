package js;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther: DGJ
 * @Date: 2024/1/10
 * @Description:
 */
@Slf4j
public class JSTest {
    
    public static void main(String[] args) throws Exception {
        String userAccount = "202004010401";
        String pwd = "123";
        //        String param = JSON.toJSONString(
        //                LoginReq.builder().loginMethod("LoginToXk").userAccount(userAccount).userPassword(pwd)
        //                        .encoded(encodeInp(userAccount, pwd)).build());
        String param = String.format("loginMethod=LoginToXk&userAccount=%s&userPassword=%s&encoded=%s", userAccount,
                pwd, encodeInp(userAccount, pwd));
        
        // 发送POST请求（Form表单）
        FormBody.Builder formBuilder = new FormBody.Builder().add("loginMethod", "LoginToXk")
                .add("userAccount", userAccount).add("userPassword", pwd).add("encoded", encodeInp(userAccount, pwd));
        System.out.println(formBuilder);
        try {
            String formResponse = OkHttpExample.doPostRequest("https://jiaowu3.nsmc.edu.cn/jsxsd/xk/LoginToXk",
                    formBuilder.build());
            System.out.println("Form POST Response: " + formResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(OkHttpExample.doPostRequest("https://jiaowu3.nsmc.edu.cn/jsxsd/xk/LoginToXk", param));
    }
    
    public static String encodeInp(String userName, String password)
            throws FileNotFoundException, ScriptException, NoSuchMethodException {
        // 1、创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        
        // 2、获取引擎
        ScriptEngine engine = manager.getEngineByName("js");
        
        // 3、加载js文件
        engine.eval(new FileReader("C:\\Users\\14761\\Desktop\\conwork.js"));
        
        // 4、调用方法获取执行结果
        Invocable invocable = (Invocable) engine;
        Object user = invocable.invokeFunction("encodeInp", userName);
        Object pwd = invocable.invokeFunction("encodeInp", password);
        return user + "%%%" + pwd;
    }
}
