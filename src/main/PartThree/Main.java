package PartThree;

import rx.Observable;
import rx.Subscriber;

public class Main {
    public static void main(String[] args) {

        StringWorker.start(5);

        StringWorker.getObsErrors()
                .flatMap(str -> Observable.from(str))
                .map(str -> StringWorker.exception(str))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("COMPLETED");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Oh, we have a error! ");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("OnNext: " + s);
                    }
                });

    }
}
