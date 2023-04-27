package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int INITIAL_VALUE = -1;
    private static final int ERROR_CODE = -1;
    private static final int MAX_NUMBERS = 12;
    private final int[] numbers = new int[MAX_NUMBERS];

    private int total = INITIAL_VALUE;


    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == INITIAL_VALUE;
    }

    public boolean isFull() {
        return total == MAX_NUMBERS-1;
    }

    protected int peekaboo() {
        if (callCheck())
            return ERROR_CODE ;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return ERROR_CODE;
        return numbers[total--];
    }

}
