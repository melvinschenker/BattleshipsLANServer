package Server;

import Client.ReadFromClient;
import Client.WriteToClient;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer {
    private ServerSocket serverSocket;
    private int numPlayers = 0;
    private final int maxPlayers = 2;

    public GameServer() {
        System.out.println("=== GAME SERVER ===");

        try {
            serverSocket = new ServerSocket(5555);
        } catch (IOException ex) {
            System.out.println("IOException from GameServer");
        }
    }

    public void acceptConnections() {

        try {
            System.out.println("Waiting for connections...");

            while (numPlayers < maxPlayers) {
                Socket socket = serverSocket.accept();
                DataInputStream dataIn = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

                int playerId = ++numPlayers;
                System.out.println("Player #" + playerId + " has connected.");
                dataOut.writeInt(playerId);

                WriteToClient wtc = new WriteToClient(playerId, dataOut);
                ReadFromClient rfc = new ReadFromClient(playerId, dataIn);
                wtc.sendServerOkay();

                Thread wtcThread = new Thread(wtc);
                Thread rfcThread = new Thread(rfc);
                wtcThread.start();
                rfcThread.start();
            }
            System.out.println("=== No longer accepting connections ===");

        } catch (IOException ex) {
            System.out.println("IOException from acceptConnections()");
        }

    }
}
