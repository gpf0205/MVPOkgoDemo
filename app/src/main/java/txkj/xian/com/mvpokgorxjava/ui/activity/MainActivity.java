package txkj.xian.com.mvpokgorxjava.ui.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import txkj.xian.com.mvpokgorxjava.R;
import txkj.xian.com.mvpokgorxjava.base.BaseMvpActivity;
import txkj.xian.com.mvpokgorxjava.bean.BannerBean;
import txkj.xian.com.mvpokgorxjava.ui.presenter.MainPresenter;
import txkj.xian.com.mvpokgorxjava.ui.view.MainView;

public class MainActivity extends BaseMvpActivity<MainView, MainPresenter> implements MainView {

    private TextView data;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        data = findViewById(R.id.data);
    }

    // 获取presenter实例
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    // View接口中定义的方法
    @Override
    public void showProgressDialog() {
        showLoadingDialog("数据加载中..");
    }

    @Override
    public void hideProgressDialog() {
        hideLoadingDialog();
    }

    @Override
    public void onSuccess(List<BannerBean> list) {
        data.setText(list.get(1).getTitle());
    }

    @Override
    public void onError(Throwable exception) {
        // 数据获取失败
        Toast.makeText(this, "数据获取失败 ", Toast.LENGTH_SHORT).show();
    }

    // 按钮的点击事件
    public void getData(View view) {
        // 通过presenter调用网络请求的方法
        getPresenter().getBannerData();
    }

}
