package com.edsolstice.jetty;

import java.io.IOException;
import java.net.Socket;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;



public class JettyServer  {
	 public static int PORT = Integer.parseInt(System.getProperty("PORT", "8080"));
	private static void makeSureServerIsNotAlreadyRunning() {
        try {
            Socket s = new Socket("localhost", PORT);
            throw new RuntimeException("Server is already running on port " + PORT + " can't start test with fresh jetty!");
        } catch (IOException e) {
            return;
        }
    }
	
	public static void startJetty() throws Exception {
		makeSureServerIsNotAlreadyRunning();
		final Server server = new Server();
        final SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(PORT);
        server.addConnector(connector);
 
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase(".");
        
        
        WebAppContext webapp = new WebAppContext("./mfg/edsolstice.war","/edsolstice");
       
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, webapp });
        
        server.setHandler(handlers);
 
        server.start();
       // server.join();
        
        int portNumber = server.getConnectors()[0].getLocalPort();
       
        makeSureServerIsRunning(portNumber);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    server.stop();
                    connector.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
	
	 private static void makeSureServerIsRunning(int portNumber) throws InterruptedException {
	        makeSureServerIsRunning(10, portNumber);
	    }
	 private static void makeSureServerIsRunning(long maxWaitSecs, int portNumber) throws InterruptedException {
	        long start = System.currentTimeMillis();
	        boolean started = false;

	        long delta = System.currentTimeMillis() - start;
	        while (!started && (delta < 1000 * maxWaitSecs)) {
	            try {
	                Socket s = new Socket("localhost", portNumber);
	                started = true;
	            } catch (IOException e) {
	                // expected while the server is not yet up
	            }
	            if (!started) {
	                Thread.sleep(50);
	                delta = System.currentTimeMillis() - start;
	            }
	        }
	        if (delta >= 1000 * maxWaitSecs) {
	            throw new IllegalStateException("Jetty failed to startup");
	        }
	    }
	 
	           
}
