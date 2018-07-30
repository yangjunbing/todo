package projects.bing.dto;

/**
 * Created by yang on 2017/2/22.
 */
public class JsonResult<T> {
    private boolean flag;
    private T data;
    private String message;

    /**
     * 请求返回结果
     * @param flag   请求成功标识
     * @param data   返回对象
     */
    public JsonResult(boolean flag, T data) {
        this.flag=flag;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
