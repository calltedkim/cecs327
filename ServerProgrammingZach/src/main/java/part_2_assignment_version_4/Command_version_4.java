/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part_2_assignment_version_4;

import java.util.Random;

public class Command_version_4 {

    private int mCommandID;
    private int mRequestorID;
    private int mCommand;
    private String mResult;
    private boolean mResultStatus;

    public Command_version_4() {
        mResult = "";
    }

    public Command_version_4(int commandID, int requestorID) {
        mCommandID = commandID;
        mRequestorID = requestorID;
        mCommand = new Random().nextInt(5) + 1;
        mResult = "";
        mResultStatus = false;
    }

    public int getmUThreadID() {
        return mRequestorID;
    }

    public int getCommandID() {
        return mCommandID;
    }


    public int getCommand() {
        return mCommand;
    }

    public String getResult() {
        return mResult;
    }

    public void setResult(String inputResult) {
        mResult = inputResult;
    }

    public boolean validateResult() {
        boolean result = true;
        if (mResult.equals("0") || mResult.equals("-1")) {
            result = false;
        }
        return result;
    }


    public void printOut() {
        String result = "mCommandID " + mCommandID + ", mRequestorID "
                + mRequestorID + ", mCommand " + mCommand + ", mResult "
                + mResult + ", mResultStatus " + mResultStatus;
        System.out.println(result);

    }

    public static void main(String[] args) {

        test2();
        test1();

    }

    public static void test1() {
        Command_version_4[] commands = new Command_version_4[10];

        for (int i = 0; i < 10; i++) {
            int commandID = i + 1;
            int reqestorID = 1;
            commands[i] = new Command_version_4(commandID, reqestorID);
            commands[i].setResult("" + (new Random().nextInt(5) + -1));
            commands[i].printOut();
        }
    }

    public static void test2() {
        Command_version_4 command = new Command_version_4(1, 1);
        System.out.println("command.validateResult() = " + command.validateResult()); //return true
        command.setResult("123");
        System.out.println("command.validateResult() = " + command.validateResult()); //return true
        command.setResult("0");
        System.out.println("command.validateResult() = " + command.validateResult()); //return false
        command.setResult("-1");
        System.out.println("command.validateResult() = " + command.validateResult()); //return false
        /*
        Building ServerProgrammingTed 1.0-SNAPSHOT
        ------------------------------------------------------------------------

        --- exec-maven-plugin:1.2.1:exec (default-cli) @ ServerProgrammingTed ---
        command.validateResult() = true
        command.validateResult() = true
        command.validateResult() = false
        command.validateResult() = false
         */
    }

}
