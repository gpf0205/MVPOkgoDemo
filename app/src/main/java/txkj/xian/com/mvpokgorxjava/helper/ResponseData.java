package txkj.xian.com.mvpokgorxjava.helper;

import java.io.Serializable;

/**
 * 全应用通用的接口返回数据包装层
 */

public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public int errorCode;
    public String errorMsg;
    public T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LzyResponse{\n" +//
                "\tcode=" + errorCode + "\n" +//
                "\tmsg='" + errorMsg + "\'\n" +//
                "\tdata=" + data + "\n" +//
                '}';
    }
}
