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
        try {
            DataInputStream in;

            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("Server running\nListening to PORT " + PORT);

            while (true)
            {
                Socket connection = ss.accept();

                if (verbose)
                {
                    System.out.println("Connection opened @ " + new Date());

                }

                in = new DataInputStream(connection.getInputStream());
                String message = in.readUTF();
                while (!message.equalsIgnoreCase("over"))
                {
                    System.out.println(message);
                    message = in.readUTF();
                    stop = true;

                }
                connection.close();
                ss.close();

            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
