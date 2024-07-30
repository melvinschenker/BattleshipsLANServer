import Server.GameServer;

public class Main {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer();
        gameServer.acceptConnections();

    }
}