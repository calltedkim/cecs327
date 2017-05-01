package part_2_assignment_version_final;

import part_2_assignment_version_final.object.SharedResource;
import part_2_assignment_version_final.object.VALUE;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Stateful_Server_Listener extends Thread {

    private boolean mListeningBoolean;

    public Stateful_Server_Listener() {
        mListeningBoolean = true;
    }

    @Override
    public void run() {

        int id = 0;

        SharedResource sharedResource = new SharedResource();

        try {
            System.out.println("(Server Listener started at " + Inet4Address.getLocalHost().getHostAddress() + " )");
        } catch (UnknownHostException ex) {
            System.out.println("UnknownHostException occured in Stateful Server Listener");
        }

        try (ServerSocket serverSocket = new ServerSocket(VALUE.SERVER_PORT_NUMBER)) {

            while (mListeningBoolean) {

                try {
                    new Stateful_Server(serverSocket.accept(), ++id, sharedResource).start();
                    TimeUnit.NANOSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    mListeningBoolean = false;
                }
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + VALUE.SERVER_PORT_NUMBER);
        } finally {
            System.out.println("(Server Listener ended)");
        }

    }

    public static void main(String[] args) {
        new Stateful_Server_Listener().start();
    }

}