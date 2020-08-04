package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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


//public class GetMessageHandler



/*
public class Main
{
    private final int PORT = 6666;


    public void send_message()
    {
        DataInputStream in = null;
        DataOutputStream out = null;
        Socket socket = null;

        try
        {
            socket = new Socket("localhost" , PORT);
            System.out.println("Connected");

            in  = new DataInputStream(System.in);
            out    = new DataOutputStream(socket.getOutputStream());
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


    }



    public static void main(String args[])
    {
        Main my_client = new Main();
        my_client.send_message();
    }

}


public class SendMessage extends Thread
{
    pubb

}

 */