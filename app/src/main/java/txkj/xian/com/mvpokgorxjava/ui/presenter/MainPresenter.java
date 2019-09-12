package txkj.xian.com.mvpokgorxjava.ui.presenter;

import java.util.List;

import io.reactivex.disposables.Disposable;
import txkj.xian.com.mvpokgorxjava.api.ApiService;
import txkj.xian.com.mvpokgorxjava.base.BasePresenter;
import txkj.xian.com.mvpokgorxjava.bean.BannerBean;
import txkj.xian.com.mvpokgorxjava.helper.BaseObserver;
import txkj.xian.com.mvpokgorxjava.helper.BaseRx;
import txkj.xian.com.mvpokgorxjava.helper.ResponseData;
import txkj.xian.com.mvpokgorxjava.ui.view.MainView;

/**
 * Created by AnOnYm on 2019/9/10.
 */

public class MainPresenter extends BasePresenter<MainView> {

    // 一般来说Presenter中应该持有M层和V层的引用
    // M层引用 --- 通过getMvpView()获取引用

    // 获取顶部播图数据
    public void getBannerData() {
        ApiService.getBannerData()
                .compose(BaseRx.<ResponseData<List<BannerBean>>>io4main()) // IO线程中发起请求，在主线程中获取结果
                .subscribe(new BaseObserver<ResponseData<List<BannerBean>>>() {

                    @Override
                    public void _onSubscribe(Disposable disposable) {
                        //请求加入管理,统一管理订阅,防止内存泄露
                        addDisposable(disposable);
                        // 显示进度提示
                        getMvpView().showProgressDialog();
                    }

                    @Override
                    public void _onSuccess(ResponseData<List<BannerBean>> listResponseData) {
                        getMvpView().onSuccess(listResponseData.getData());
                    }

                    @Override
                    public void _onError(Throwable exception) {
                        getMvpView().onError(exception);
                    }

                    @Override
                    public void _onComplete() {
                        // 隐藏进度
                        getMvpView().hideProgressDialog();
                    }
                });
    }
}
