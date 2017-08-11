package com.core.java.v2.v2ch03. interruptible;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * The type Interruptible socket test.
 */
public class InterruptibleSocketTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new InterruptibleSocketFrame();
               frame.setTitle("InterruptibleSocketTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Interruptible socket frame.
 */
class InterruptibleSocketFrame extends JFrame
{
   /**
    * The constant TEXT_ROWS.
    */
   public static final int TEXT_ROWS = 20;
   /**
    * The constant TEXT_COLUMNS.
    */
   public static final int TEXT_COLUMNS = 60;

   private Scanner in;
   private JButton interruptibleButton;
   private JButton blockingButton;
   private JButton cancelButton;
   private JTextArea messages;
   private TestServer server;
   private Thread connectThread;

   /**
    * Instantiates a new Interruptible socket frame.
    */
   public InterruptibleSocketFrame()
   {
      JPanel northPanel = new JPanel();
      add(northPanel, BorderLayout.NORTH);

      messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
      add(new JScrollPane(messages));

      interruptibleButton = new JButton("Interruptible");
      blockingButton = new JButton("Blocking");

      northPanel.add(interruptibleButton);
      northPanel.add(blockingButton);

      interruptibleButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               interruptibleButton.setEnabled(false);
               blockingButton.setEnabled(false);
               cancelButton.setEnabled(true);
               connectThread = new Thread(new Runnable()
                  {
                     public void run()
                     {
                        try
                        {
                           connectInterruptibly();
                        }
                        catch (IOException e)
                        {
                           messages.append("\nInterruptibleSocketTest.connectInterruptibly: " + e);
                        }
                     }
                  });
               connectThread.start();
            }
         });

      blockingButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               interruptibleButton.setEnabled(false);
               blockingButton.setEnabled(false);
               cancelButton.setEnabled(true);
               connectThread = new Thread(new Runnable()
                  {
                     public void run()
                     {
                        try
                        {
                           connectBlocking();
                        }
                        catch (IOException e)
                        {
                           messages.append("\nInterruptibleSocketTest.connectBlocking: " + e);
                        }
                     }
                  });
               connectThread.start();
            }
         });

      cancelButton = new JButton("Cancel");
      cancelButton.setEnabled(false);
      northPanel.add(cancelButton);
      cancelButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connectThread.interrupt();
               cancelButton.setEnabled(false);
            }
         });
      server = new TestServer();
      new Thread(server).start();
      pack();
   }

   /**
    * Connect interruptibly.
    *
    * @throws IOException the io exception
    */
   public void connectInterruptibly() throws IOException
   {
      messages.append("Interruptible:\n");
      try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189)))
      {
         in = new Scanner(channel);
         while (!Thread.currentThread().isInterrupted())
         {
            messages.append("Reading ");
            if (in.hasNextLine())
            {
               String line = in.nextLine();
               messages.append(line);
               messages.append("\n");
            }
         }
      }
      finally
      {
         EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               messages.append("Channel closed\n");
               interruptibleButton.setEnabled(true);
               blockingButton.setEnabled(true);
            }
         });
      }
   }

   /**
    * Connect blocking.
    *
    * @throws IOException the io exception
    */
   public void connectBlocking() throws IOException
   {
      messages.append("Blocking:\n");
      try (Socket sock = new Socket("localhost", 8189))
      {
         in = new Scanner(sock.getInputStream());
         while (!Thread.currentThread().isInterrupted())
         {
            messages.append("Reading ");
            if (in.hasNextLine())
            {
               String line = in.nextLine();
               messages.append(line);
               messages.append("\n");
            }
         }
      }
      finally
      {
         EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               messages.append("Socket closed\n");
               interruptibleButton.setEnabled(true);
               blockingButton.setEnabled(true);
            }
         });      
      }
   }

   /**
    * The type Test server.
    */
   class TestServer implements Runnable
   {
      public void run()
      {
         try
         {
            ServerSocket s = new ServerSocket(8189);

            while (true)
            {
               Socket incoming = s.accept();
               Runnable r = new TestServerHandler(incoming);
               Thread t = new Thread(r);
               t.start();
            }
         }
         catch (IOException e)
         {
            messages.append("\nTestServer.run: " + e);
         }
      }
   }

   /**
    * The type Test server handler.
    */
   class TestServerHandler implements Runnable
   {
      private Socket incoming;
      private int counter;

      /**
       * Instantiates a new Test server handler.
       *
       * @param i the
       */
      public TestServerHandler(Socket i)
      {
         incoming = i;
      }

      public void run()
      {
         try 
         {
            try
            {
               OutputStream outStream = incoming.getOutputStream();
               PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
               while (counter < 100)
               {
                  counter++;
                  if (counter <= 10) out.println(counter);
                  Thread.sleep(100);
               }
            }
            finally
            {
               incoming.close();
               messages.append("Closing server\n");
            }
         }
         catch (Exception e)
         {
            messages.append("\nTestServerHandler.run: " + e);
         }
      }
   }
}
