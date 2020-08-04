package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SendMessageHandler extends Thread
{

    private Socket s;
    SendMessageHandler(Socket s )
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        DataInputStream din = null;
        DataOutputStream dout = null;
        try
        {
             din = new DataInputStream(System.in);
             dout = new DataOutputStream(s.getOutputStream());

        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        String line = "";
        while (!line.equalsIgnoreCase("over")) {
            try {
                line = din.readLine();
                dout.writeUTF(line);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            dout.close();
            din.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
