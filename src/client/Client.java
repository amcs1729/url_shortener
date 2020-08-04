package client;
import java.net.Socket;

public class Client
{
    private int PORT;
    Client()
    {
        this.PORT = 6666;
    }
    public static void main(String args[])
    {
        Client new_client = new Client();
        CreateConnection connection = new CreateConnection(new_client.PORT);
        ConnectionStatus connectionstatus = connection.connect();
        if(connectionstatus.status == true)
        {
            System.out.println("Connected to Server @ PORT "+ new_client.PORT );
            Socket new_socket = connectionstatus.s;
            try
            {
                //DataOutputStream dout = new DataOutputStream(new_socket.getOutputStream());
                //DataInputStream din = new DataInputStream(new_socket.getInputStream());
                Thread t = new SendMessageHandler(new_socket);
                t.run();
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        }

    }
}