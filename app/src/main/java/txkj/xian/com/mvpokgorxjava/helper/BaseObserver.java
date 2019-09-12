package txkj.xian.com.mvpokgorxjava.helper;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 每次订阅Observable时都有一大串重写的方法，然而我们只关心请求成功与否和请求成功后返回的数据
 */

public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d){
        //订阅刚开始的时候
        _onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        _onSuccess(t);
    }
    @Override
    public void onError(Throwable e) {
        _onError(e);
    }
    @Override
    public void onComplete() {
        // onComplete方法和onError方法是互斥的，onComplete和onError只会调用其中一个，不可能同时被触发
        // RxJava 规定，当不会再有新的 onNext() 发出时，需要调用 onCompleted() 方法作为标志。
        _onComplete();
    }

    public void _onSubscribe(Disposable d) {

    }
    public void _onComplete() {

    }

    //抽象方法，必须实现
    public abstract void _onSuccess(T t);
    public abstract void _onError(Throwable e);

}
