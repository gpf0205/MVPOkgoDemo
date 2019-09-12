package txkj.xian.com.mvpokgorxjava.helper;

import java.io.Serializable;

/**
 * 接口返回数据data部分为空
 */

public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -1477609349345966116L;

    public int errorCode;
    public String errorMsg;

    public ResponseData toLzyResponse() {
        ResponseData lzyResponse = new ResponseData();
        lzyResponse.errorCode = errorCode;
        lzyResponse.errorMsg = errorMsg;
        return lzyResponse;
    }
}