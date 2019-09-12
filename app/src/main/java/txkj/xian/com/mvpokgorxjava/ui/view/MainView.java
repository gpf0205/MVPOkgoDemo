package txkj.xian.com.mvpokgorxjava.ui.view;

import java.util.List;

import txkj.xian.com.mvpokgorxjava.base.BaseView;
import txkj.xian.com.mvpokgorxjava.bean.BannerBean;

/**
 * Created by AnOnYm on 2019/9/10.
 */

public interface MainView extends BaseView {

    void onSuccess(List<BannerBean> list);

}
