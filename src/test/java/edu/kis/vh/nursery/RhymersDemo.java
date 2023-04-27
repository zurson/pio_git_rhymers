package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static final int MAX_NUMBERS_IN_ROW = 15;
    public static final int ROWS = 15;
    public static final int MAX_RANDOM_NUMBER = 20;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};
        
        for (int i = 1; i < MAX_NUMBERS_IN_ROW; i++)
            for (int j = 0; j < ROWS; j++)
                rhymers[j].countIn(i);
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < MAX_NUMBERS_IN_ROW; i++)
            rhymers[3].countIn(rn.nextInt(MAX_RANDOM_NUMBER));
        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());
        
    }
    
}