package txkj.xian.com.mvpokgorxjava.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 25367 on 2018/12/24.
 */

public abstract class BaseFragment extends Fragment {

    private View mRootView;
    protected Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(),container,false);
        initPresenter();
        initView();
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        setListener();
        super.onActivityCreated(savedInstanceState);
    }

    // 实例化presenter
    protected void initPresenter(){}
    protected void initView(){}
    protected void initData(){}
    protected void setListener(){}
    protected abstract int getContentViewId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
