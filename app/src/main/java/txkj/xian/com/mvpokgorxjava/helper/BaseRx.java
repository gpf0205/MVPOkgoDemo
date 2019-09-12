package txkj.xian.com.mvpokgorxjava.helper;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 线程调度：
 * 每次请求时候的时候都需要.subscribeOn(Schedulers.io())和.observeOn(AndroidSchedulers.mainThread())这样不是很麻烦？
 * 有了该类，以后只需要使用RxJava的操作符compose就可以了：
 * .compose(BaseRx.<BaseResult<List<Book>>>io4main()) //使用compose转换线程
 */

public class BaseRx {

    private BaseRx() {
        throw new RuntimeException("you con't instantiate me");
    }

    public static <T> ObservableTransformer<T, T> io4main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io());
            }
        };
    }

}
