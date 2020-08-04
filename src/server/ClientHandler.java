package server;

import java.io.DataInputStream;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread
{
    private boolean verbose;
    private Socket s;
    private DataInputStream in;
    private Date start;

    ClientHandler(boolean verbose, Socket s)
    {
        this.verbose = verbose;
        this.s = s;
        in = null;
        start = new Date();
    }

    @Override
    public void run()
    {
        if(verbose)
        {
                System.out.println("Connection opened @ " + new Date());
        }

        try
        {
            in = new DataInputStream(s.getInputStream());
            String message = in.readUTF();
            while (!message.equalsIgnoreCase("over"))
            {
                System.out.println(message);
                message = in.readUTF();

            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try {
                System.out.println("|||Start "+start+"||| Ended at "+ new Date()+"|||");
                s.close();
            }
            catch(Exception e)
            {
                System.err.println(e.getMessage());
            }

        }

    }
}
