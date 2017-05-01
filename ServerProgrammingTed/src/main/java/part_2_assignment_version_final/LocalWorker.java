package part_2_assignment_version_final;

import static part_2_assignment_version_final.object.VALUE.echo;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LocalWorker implements Runnable, Callable<String> {

    private Number mNumber;
    private ReentrantLock mLock;
    private int mCommand;
    private int mClientID;
    private String mResult;

    public LocalWorker(Number inputNumber, ReentrantLock inputLock, int inputClientID, int command) {
        mNumber = inputNumber;
        mLock = inputLock;
        mResult = "0";
        mClientID = inputClientID;
        mCommand = command;
    }

    @Override
    public void run() {
        mLock.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
            switch (mCommand) {
                case 4:
                    mResult = "" + mNumber.getNextEvenNumber();
                    break;
                case 5:
                    mResult = "" + mNumber.getNextOddNumber();
                    break;
                default:
                    mResult = "" + "-1";
                    break;
            }
        } catch (InterruptedException ex) {
            echo("InterruptedException occured in LocalWorker" +  mClientID + "," + mCommand + "," + mResult);
        } finally {
            mLock.unlock();
        }
    }

    @Override
    public String call() throws Exception {
        return mClientID + "," + mCommand + "," + mResult;
    }
}
