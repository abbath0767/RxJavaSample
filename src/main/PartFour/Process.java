package PartFour;

import java.util.Random;

public class Process extends Thread {

    private String name;
    private int duration;
    private int[] myArray;

    private Process(String name, int duration) {
        this.name = name;
        this.duration = duration;
        Logger.log("Process %s create. d = " + duration, name);
    }

    @Override
    public void run() {
        Logger.log("Process %s start! d = " + duration + " sec", name);
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myArray = downloadBytes();
        Logger.log("Precess %s finish", name);
    }

    @Override
    public String toString() {
        return name;
    }

    private int[] downloadBytes() {
        int bound = 100;
        Random rand = new Random(31);

        return new int[] {rand.nextInt(bound),
                rand.nextInt(bound),
                rand.nextInt(bound),
                rand.nextInt(bound)};
    }

    public int[] getData() {
        return myArray;
    }

    public static Process newProcess(String name, int duration) {
        return new Process(name, duration);
    }
}
