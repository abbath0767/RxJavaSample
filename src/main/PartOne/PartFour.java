package PartOne;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class PartFour {

    static String testString = "Hello rx world";

    public static void main(String[] args) {

        Observable.just("my string").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + " version v2";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });

        Observable.just("my hashing string").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.hashCode();
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("Hash code: " + Integer.toString(integer));
            }
        });




        Observable<String> myObs = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("call in myObs: " + testString);
                subscriber.onNext("on next myObs: " + testString);
            }
        });

        Action1<String> actionToHashCode = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.print("actionToHashCode: ");
                System.out.println(s.hashCode());
            }
        };

        Action1<String> actionUpperToCase = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.print("actionToUpperCase: ");
                System.out.println(s.toUpperCase());
            }
        };

        myObs.subscribe(actionToHashCode);
        myObs.subscribe(actionUpperToCase);
        myObs.map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.length();
            }
        }).subscribe(s -> System.out.println("anonimus length: " + s));

    }
}
