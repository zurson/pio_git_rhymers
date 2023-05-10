package edu.kis.vh.nursery;

public class FifoRhymer extends DefaultCountingOutRhymer {

    private final DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

    @Override
    public int countOut() {
        while (!callCheck())
            rhymer.countIn(super.countOut());

        int ret = rhymer.countOut();

        while (!rhymer.callCheck())
            countIn(rhymer.countOut());

        return ret;
    }
}
