package PartOne.test;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;

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

        Observable.just(p1, new Person("victor", 99), new Person("adddi", 3))
                .map(new Func1<Person, String>() {
                    @Override
                    public String call(Person person) {
                        return person.getName() + " have " + person.getAge() + " age";
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("action call " + s);
            }
        });

        Observable.just(p2, new Person("sergey", 13))
                .map(p -> p.getName().length() + p.getAge())
                .subscribe(s -> System.out.println("summ name length and age: " + s));

    }
}
