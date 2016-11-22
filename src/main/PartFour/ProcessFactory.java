package PartFour;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessFactory {
    private static List<Process> mProcessList = new ArrayList<>();

    public static Observable<List<Process>> generateProcessing(int count) {
        Random rand = new Random(71);
        int bound = 5;

        for (int i = 0; i < count; i++)
            mProcessList.add(Process.newProcess("Process" + i, rand.nextInt(bound)));

        return Observable.just(mProcessList);
    }
}
