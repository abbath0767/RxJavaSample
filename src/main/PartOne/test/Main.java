package PartOne.test;

import rx.Observable;
import rx.Observer;

public class Main {
    public static void main(String[] args) {
        PersonNameList mySubscriberList = new PersonNameList();

        Person p1 = new Person("paul", 13);
        Person p2 = new Person("patric", 11);
        Person p3 = new Person("varfolomey", 1032);

        Observable<Person> myObs = Observable.just(p1, p2, p3);

        myObs.subscribe(mySubscriberList);

        for (Person p: mySubscriberList)
            System.out.println(p);
    }
}
