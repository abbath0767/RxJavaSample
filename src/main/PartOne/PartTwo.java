package PartOne;

import rx.Observable;
import rx.functions.Action;
import rx.functions.Action1;
import rx.functions.Action2;

public class PartTwo {
    public static void main(String[] args) {
        Observable<String> myObs = Observable.just("Text Message");

        Action1<String> actionNext = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("call in action: " + s);
            }
        };

        myObs.subscribe(actionNext);


    }
}
