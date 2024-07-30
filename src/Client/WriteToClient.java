package Client;

import java.io.DataOutputStream;
import java.io.IOException;

    public class WriteToClient implements Runnable {
        private final int playerId;
        private final DataOutputStream dataOut;

        public WriteToClient(int playerId, DataOutputStream dataOut){
            System.out.println("WriteToClient: #" + playerId + " Runnable created");

            this.playerId = playerId;
            this.dataOut = dataOut;
        }

        public void sendServerOkay() {
            try {
                dataOut.writeUTF("=== SERVER OKAY ===");
            } catch (IOException ex) {
                System.out.println("IOException from sendStartMsg().");
            }
        }

        @Override
        public void run() {
            while (true) {
                try {

                    // Write current game state

                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    System.out.println("InterruptedException from sendStartMsg().");
                }
            }
        }
    }