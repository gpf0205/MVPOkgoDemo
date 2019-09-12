package txkj.xian.com.mvpokgorxjava.base;

/**
 * Created by AnOnYm on 2019/9/5.
 */

public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity {

    private P presenter;

    @Override
    protected void initPresenter() {
        //实例化Presenter
        presenter = createPresenter();
        //绑定
        if (presenter != null){
            presenter.attachView((V) this);
        }
    }

    // 初始化Presenter
    protected abstract P createPresenter();

    protected P getPresenter(){
        return presenter;
    }


    @Override
    protected void onDestroy() {
        //解绑
        if (presenter != null){
            presenter.detachView();
        }
        super.onDestroy();
    }

}
