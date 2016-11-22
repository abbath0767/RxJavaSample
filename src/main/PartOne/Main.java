package PartOne;


import rx.Observable;
import rx.Subscriber;

public class Main {

    static int num = 1;

    public static void main(String[] args) {

        printNum();

        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        incrementNum();
                        printNum();
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
                incrementNum();
                printNum();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
            }
        };

        myObservable.subscribe(mySubscriber);


    }

    private static void printNum() {
        System.out.println(num);
    }

    private static void incrementNum() {
        num++;
    }
}
