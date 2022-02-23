package event;

import org.springframework.context.ApplicationEvent;

public class DemoEventOne extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    public String msg;

    public DemoEventOne(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
