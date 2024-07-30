package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadFromClient implements Runnable {
    private final int playerId;
    private final DataInputStream dataIn;

    public ReadFromClient(int playerId, DataInputStream dataIn){
        System.out.println("ReadFromCient: #" + playerId + " Runnable created");

        this.playerId = playerId;
        this.dataIn = dataIn;
    }


    @Override
    public void run() {
        while (true) {
            try {
                String input = dataIn.readUTF();
                System.out.println(input);

                Thread.sleep(250);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("=== Lost connection to Player #" + playerId);
            }
        }
    }
}