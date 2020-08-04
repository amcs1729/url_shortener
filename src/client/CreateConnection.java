package client;

import java.net.Socket;

public class CreateConnection
{
    private int PORT;
    public Socket s;

    CreateConnection(int PORT)
    {
        this.PORT = PORT;
    }
    public ConnectionStatus connect()
    {
        try
        {
            s = new Socket("localhost" ,PORT);
            ConnectionStatus newconnection = new ConnectionStatus(true, s);
            return newconnection;
        }
        catch (Exception e)
        {
            ConnectionStatus newconnection = new ConnectionStatus(false, null);
            return newconnection;
        }

    }
}
