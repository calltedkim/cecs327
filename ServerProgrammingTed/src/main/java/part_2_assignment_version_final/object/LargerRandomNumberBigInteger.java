package part_2_assignment_version_final.object;

import java.math.BigInteger;

/**
 * generate the next larger random number
 */
public class LargerRandomNumberBigInteger {

    private BigInteger mValue;

    /**
     * initialize a LargerRandomNumber object with seed value of 0
     */
    public LargerRandomNumberBigInteger() {
        mValue = BigInteger.valueOf(0);
    }

    private void reset() {
        mValue = BigInteger.valueOf(1);
    }

    /**
     *
     * @return the next larger random value
     */
    public BigInteger getNextLargerRand() {

        try {
            mValue = mValue.add(BigInteger.valueOf(VALUE.getRandomNumberBetween(1000, 1)));
        } catch (OutOfMemoryError e) {
            reset();
        }

        return mValue.abs();
    }
}