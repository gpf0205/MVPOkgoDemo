package txkj.xian.com.mvpokgorxjava.base;

/**
 * Created by 25367 on 2018/12/24.
 */

public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter<V>> extends BaseFragment {

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
    public void onDestroy() {
        //解绑
        if (presenter != null){
            presenter.detachView();
        }
        super.onDestroy();
    }

}
