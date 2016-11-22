package PartTwo.P1;

import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UrlWorker {

    public static List<String> tittles = new ArrayList<>();

    public static Observable<List<String>> query(String text) {
        return Observable.just(
                new ArrayList<>(Arrays.asList(new String[] {"google.com", "rxjava.com", text + ".com"})));
    }

    public static void connect(String url) {
        System.out.println("connected to: " + url);
    }

    public static Observable<String> getTitle(String url) {
        return Observable.just(url.substring(0, url.indexOf(".")));
    }

    public static void saveTitle(String title) {
        tittles.add(title);
    }


    public static Integer getCount() {
        return tittles.size();
    }
}
