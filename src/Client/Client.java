package Client;

public class Client {
    private WriteToClient wtc;
    private ReadFromClient rfc;

    public Client(WriteToClient wtc, ReadFromClient rfc) {
        wtc = wtc;
        rfc = rfc;
    }
}
