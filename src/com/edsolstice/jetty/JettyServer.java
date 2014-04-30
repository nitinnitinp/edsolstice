package com.edsolstice.jetty;

import java.io.File;
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
    String jetty_server_pid = "jetty_server_pid" ;
    
    private static void makeSureServerIsNotAlreadyRunning() {
        try {
            Socket s = new Socket("localhost", PORT);
            throw new RuntimeException("Server is already running on port " + PORT + " can't start test with fresh jetty!");
        } catch (IOException e) {
            return;
        }
    }

    public static void startJetty() throws Exception {
        File jetty_server_pid = new File("./mfg/jetty_server_pid") ;
        if(jetty_server_pid.exists()) throw new RuntimeException("Jetty Server is running , please run ant stopJetty");
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

       
       
        jetty_server_pid.createNewFile();
       
        server.setGracefulShutdown( 1000 );
        server.setStopAtShutdown(true);
        server.start();
        
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                       
                        if(!isJettyRunning()) {
                            
                            server.stop();
                            connector.stop();
                            return ;
                        }
                        
                        Thread.sleep(5000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean isJettyRunning() {
               File jetty_server_pid = new File("./mfg/jetty_server_pid") ;
               return  jetty_server_pid.exists();
            }
        }.start();

       
        int portNumber = server.getConnectors()[0].getLocalPort();
        makeSureServerIsRunning(portNumber);

       


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
