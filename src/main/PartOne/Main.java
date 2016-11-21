package PartOne;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Main {
    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("Hello world!");
                observableEmitter.onComplete();
            }
        });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplite");
            }
        };

        myObservable.subscribe((Observer<? super String>) mySubscriber);

    }
}
