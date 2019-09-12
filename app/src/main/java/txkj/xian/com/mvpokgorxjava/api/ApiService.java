package txkj.xian.com.mvpokgorxjava.api;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okrx2.adapter.ObservableBody;

import java.util.List;

import io.reactivex.Observable;
import txkj.xian.com.mvpokgorxjava.bean.BannerBean;
import txkj.xian.com.mvpokgorxjava.helper.JsonConvert;
import txkj.xian.com.mvpokgorxjava.helper.ResponseData;

/**
 * Created by AnOnYm on 2019/9/10.
 */

public class ApiService {

    /**
     * 首页Banner
     *
     * @GET("/banner/json")
     */
    public static Observable<ResponseData<List<BannerBean>>> getBannerData() {
        return OkGo.<ResponseData<List<BannerBean>>>get(Api.HOME_BANNER)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .converter(new JsonConvert<ResponseData<List<BannerBean>>>() {
                })
                .adapt(new ObservableBody<ResponseData<List<BannerBean>>>());
    }

}
