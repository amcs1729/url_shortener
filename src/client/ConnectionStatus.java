package client;


import java.net.Socket;

public class ConnectionStatus
{
    public boolean status;
    public Socket s;

    ConnectionStatus(boolean status , Socket s)
    {
        this.status = status;
        this.s = s;
    }

}
