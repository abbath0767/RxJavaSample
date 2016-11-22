package PartFour;

import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int counter = 0;

    public static void main(String[] args) {

//        ProcessFactory.generateProcessing(5)
//                .flatMap(processes -> Observable.from(processes))
//                .flatMap(process -> Observable.just(process))
//                .doOnNext(process -> {
//                    process.start();
//                })
//                .subscribe(process -> System.out.println(process.toString() + " subscribed"));
//
//        System.out.println("<><><><><><><><><><>");


        Observable<Process> observable = Observable.create(new Observable.OnSubscribe<Process>() {
            @Override
            public void call(Subscriber<? super Process> subscriber) {
                Random rand = new Random();
                int bound = 4;
                Process p = Process.newProcess("P" + counter++, rand.nextInt(bound));
                subscriber.onNext(p);
                try {
                    p.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("COMPLETE");
                System.out.println("data: " + Arrays.toString(p.getData()));
                subscriber.onCompleted();
            }
        });
//
        Subscriber<Process> subscriber = new Subscriber<Process>() {
            @Override
            public void onCompleted() {
                System.out.println("onComplited");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error: " + throwable.toString());
            }

            @Override
            public void onNext(Process process) {
                System.out.println("onNext: " + process.toString());
                process.start();
            }
        };

        observable.subscribe(subscriber);


    }
}
