package rpc.exception;

/***
 * @Author trojan
 * @Date 2022/6/9 16:23
 * @Description 自定义序列化异常
 * @Version 1.0
 */

public class SerializerException extends RuntimeException {

    public SerializerException(String message) {
        super(message);
    }
}