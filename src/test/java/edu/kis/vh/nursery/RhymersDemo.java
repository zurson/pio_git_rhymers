package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    private static final int MAX_NUMBERS_IN_ROW = 15;
    private static final int ROWS = 3;
    private static final int MAX_RANDOM_NUMBER = 20;

    public static void main(String[] args) {

        RhymersFactory factory = new DefaultRhymersFactory();
        testRhymers(factory);

    }

    private static void testRhymers(RhymersFactory factory) {

        DefaultCountingOutRhymer[] rhymers = rhymersInit(factory);
        fillRhymersWithKnownData(rhymers);
        fillRhymersWithRandomData(rhymers);

        printResult(rhymers);

    }

    private static DefaultCountingOutRhymer[] rhymersInit(RhymersFactory factory){

        return new DefaultCountingOutRhymer[]{factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};

    }

    private static void fillRhymersWithKnownData(DefaultCountingOutRhymer[] rhymers){

        for (int i = 1; i < MAX_NUMBERS_IN_ROW; i++)
            for (int j = 0; j < ROWS; j++)
                rhymers[j].countIn(i);

    }

    private static void fillRhymersWithRandomData(DefaultCountingOutRhymer[] rhymers){

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < MAX_NUMBERS_IN_ROW; i++)
            rhymers[3].countIn(rn.nextInt(MAX_RANDOM_NUMBER));

    }

    private static void printResult(DefaultCountingOutRhymer[] rhymers){

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());

    }

}