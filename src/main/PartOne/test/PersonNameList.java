package PartOne.test;

import rx.functions.Action1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonNameList implements Action1<Person>, Iterable<Person> {

    private List<Person> mPersons;

    public PersonNameList() {
        mPersons = new ArrayList<>();
    }

    @Override
    public void call(Person p) {
        System.out.println("add new person with name: " + p.getName());
        addNewPersonName(p);
    }

    private void addNewPersonName(Person p) {
        mPersons.add(p);
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {
            int size = mPersons.size();
            int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public Person next() {
                return mPersons.get(point++);
            }
        };
    }
}
