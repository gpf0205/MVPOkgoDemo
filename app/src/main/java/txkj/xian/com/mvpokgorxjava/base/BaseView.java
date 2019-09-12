package txkj.xian.com.mvpokgorxjava.base;

/**
 * Created by AnOnYm on 2019/9/5.
 */

/**
 * 定义通用的接口方法
 */

public interface BaseView {

    // 显示进度框
    void showProgressDialog();
    // 隐藏进度框
    void hideProgressDialog();
    // 出错信息的回调
    void onError(Throwable exception);

}
