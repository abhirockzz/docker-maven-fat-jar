package com.wordpress.abhirockzz.docker.maven.test;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class RESTResource {

    @GET
    public Response paasOffering() {

        return Response.ok("hello from a docker image built using spotify maven plugin for docker!\n" + new Date())
                .build();
    }

}
