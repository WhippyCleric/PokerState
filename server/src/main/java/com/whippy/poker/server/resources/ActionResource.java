//J-
package com.whippy.poker.server.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.whippy.poker.common.events.CallEvent;
import com.whippy.poker.common.events.PokerEvent;
import com.whippy.poker.server.orchestrators.GlobalOrchestrator;


@Path("event")
public class ActionResource {


        @Inject
        GlobalOrchestrator orchestrator;

        @POST
        @Consumes({ MediaType.APPLICATION_JSON })
        @Produces({ MediaType.APPLICATION_JSON })
        @Path("/call")
        public Response call(@QueryParam("id") String playerAlais){
                PokerEvent event = new CallEvent(playerAlais);
                orchestrator.processEvent(event);
                return Response.ok().build();
        }

        @POST
        @Consumes({ MediaType.APPLICATION_JSON })
        @Produces({ MediaType.APPLICATION_JSON })
        @Path("/fold")
        public Response fold(String jsonPlayer){
                return Response.ok().build();
        }

        @POST
        @Consumes({ MediaType.APPLICATION_JSON })
        @Produces({ MediaType.APPLICATION_JSON })
        @Path("/bet")
        public Response bet(String jsonPlayer){
                return Response.ok().build();
        }

}
//J+
