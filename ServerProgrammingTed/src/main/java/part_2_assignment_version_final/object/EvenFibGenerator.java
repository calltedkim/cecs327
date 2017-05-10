package part_2_assignment_version_final.object;

import java.math.BigInteger;

/**
 * calculate the next even fib
 */
public class EvenFibGenerator {

    private BigInteger valueNMinus2 = new BigInteger("0");
    private BigInteger valueNMinus1 = new BigInteger("1");
    private BigInteger valueN = new BigInteger("-1");

    /**
     * get the next even Fib number
     * @return even Fib in BigDecimal type
     */
    public String getNextEvenFib() {
        BigInteger result;
        do {
            result = getNextFib();
        } while (evenNumber(result) == false);
        return result.toString();
    }

    /**
     * reset the object to initalized value
     */
    private void reset() {
        valueNMinus2 = new BigInteger("0");
        valueNMinus1 = new BigInteger("1");
        valueN = new BigInteger("-1");;
    }

    /**
     * get the next Fib number
     * @return fib number in BigDecimal type
     */
    private BigInteger getNextFib() {
        try {
            if (valueN.equals("-1")) {
                valueN = valueNMinus2.add(valueNMinus1);
            } else {
                valueNMinus2 = valueNMinus1;
                valueNMinus1 = valueN;
                valueN = valueNMinus2.add(valueNMinus1);
            }
        } catch (OutOfMemoryError e) {
            reset();
            valueN = valueNMinus2.add(valueNMinus1);
        }
        return valueN;
    }

    /**
     * test if an input is even number or not
     * @param input
     * @return true if input is an even number
     */
    private boolean evenNumber(BigInteger input) {
        return ((input.remainder(BigInteger.valueOf(2))).equals(BigInteger.valueOf(0)) ? (true) : (false));
    }

}