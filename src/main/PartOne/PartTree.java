package PartOne;

import rx.Observable;
import rx.functions.Action1;

public class PartTree {

    static String newStr;

    public static void main(String[] args) {

        final String str = "test message";

        Observable.just(str).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(str + " oop");
                newStr = str.toUpperCase();
            }
        });

        System.out.println(newStr);

        Observable.just(str).subscribe(s -> System.out.println(s + " @author"));

    }
}
