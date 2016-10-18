package com.wordpress.abhirockzz.docker.maven.test;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Bootstrap {

    static void bootstrapREST() throws IOException {

        String hostname = Optional.ofNullable(System.getenv("HOSTNAME")).orElse("localhost");
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");

        URI baseUri = UriBuilder.fromUri("http://" + hostname + "/").port(Integer.parseInt(port)).build();

        ResourceConfig config = new ResourceConfig(RESTResource.class);

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        Logger.getLogger(Bootstrap.class.getName()).log(Level.INFO, "Application accessible at {0}", baseUri.toString());

        //gracefully exit Grizzly services when app is shut down
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                Logger.getLogger(Bootstrap.class.getName()).info("Exiting......");
                server.shutdownNow();
                Logger.getLogger(Bootstrap.class.getName()).info("REST services stopped");
            }
        }));
        server.start();

    }


    public static void main(String[] args) throws IOException {
        bootstrapREST();
    }
}
