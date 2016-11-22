package PartOne;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class PartFive {

    static String testStr = "Test String";

    public static void main(String[] args) {

        Observable.just(testStr)
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return Integer.toString(integer);
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });

        //or equal with lambda

        Observable.just(testStr + "2")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));

    }
}
