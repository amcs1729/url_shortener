package server;

import java.io.*;
import java.util.*;
import java.net.*;

public class Server// implements Runnable
{
    //static final File WEB_ROOT = '.';
    static final int PORT = 6666;
    static final boolean verbose = true;

    public static void main(String args[])
    {
        boolean stop=false;
        try
        {


            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("Server running\nListening to PORT " + PORT);

            while (true)
            {
                Socket connection = ss.accept();
                Thread t =  new ClientHandler(verbose , connection);
                t.run();
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
