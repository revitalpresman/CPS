package cps.server;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import cps.clientServer.ClientServerConsts;
import cps.utilities.CPS_Tracer;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerController.
 */
public class ServerController
{
    
    /**
     * Listen and response.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void ListenAndResponse() throws IOException
    {	
	try (ServerSocket serverSocket = new ServerSocket(ClientServerConsts.PORT))
	{
	    CPS_Tracer.TraceInformation("Server has started to listen on IP "
		    + InetAddress.getLocalHost().getHostAddress() + " Port " + ClientServerConsts.PORT);
	    
	    while (true)
	    {
		try
		{
		    Socket socket = serverSocket.accept();
		    
		    ServerRequestHandler.HandleRequestAsync(socket);
		}
		catch (Exception e)
		{		    
		    CPS_Tracer.TraceError(e.toString());
		    // Socked will be closed and the client will get
		    // ServerResponse with Failed result
		}
	    }
	}
	catch (Exception e)
	{
	    CPS_Tracer.TraceError(e.toString());
	}
	
	CPS_Tracer.TraceInformation("Server is shutting down.");
    }
    
    /**
     * Register timers.
     */
    private void RegisterTimers()
    {
	Timer timer = new Timer ();
	TimerTask hourlyTask = new TimerTask () {
	    @Override
	    public void run () {
	        try(ServerRequestHandler serverRequestHandler = new ServerRequestHandler())
		{
		    serverRequestHandler.UpdateReservationsStatus();
		}
		catch (Exception e)
		{
		    System.out.println(e);
		}
	    }
	};
	
	timer.schedule(hourlyTask, 0, 1000*60*60);
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception
    {
	ServerController serverController = new ServerController();
	
	serverController.RegisterTimers();
	
	serverController.ListenAndResponse();
    }
}