package PartThree;

import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringWorker {

    private static int[] errors;
    private static Random rand;
    private static List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));

    public static void start(int count) {
        errors = new int[count];
        rand = new Random();

        for (int i = 0; i < count; i++) {
            errors[i] = rand.nextInt(2);
            System.out.println(errors[i]);
        }
    }


    public static Observable<List<String>> getObsErrors() {
        return Observable.just(list);
    }


    public static String exception(String str) {
        if (errors[list.indexOf(str)] == 1)
            try {
                throw new Exception("EXCEPTION!!!!");
            } catch (Exception e) {
                return str + " have exception!: "  + e.toString();
            }

        return str + " not exception";
    }
}
