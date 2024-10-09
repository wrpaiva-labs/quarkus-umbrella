package br.com.paiva.hexagonal.adapter.in.api;

import br.com.paiva.hexagonal.port.in.CreateServiceUseCase;
import br.com.paiva.hexagonal.port.in.GetServiceByIdUseCase;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;

// Adapter
@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceResource {

    private CreateServiceUseCase createServiceUseCase;

    private GetServiceByIdUseCase getServiceByIdUseCase;

    public ServiceResource(
            final CreateServiceUseCase createServiceUseCase,
            final GetServiceByIdUseCase getServiceByIdUseCase) {

        this.createServiceUseCase = Objects.requireNonNull(createServiceUseCase);
        this.getServiceByIdUseCase = Objects.requireNonNull(getServiceByIdUseCase);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String id) {
        return Response.ok(getServiceByIdUseCase.execute(new GetServiceByIdUseCase.Input(id))).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response serviceOfName(@PathParam("name") String name) {
        return Response.ok(getServiceByIdUseCase.execute(new GetServiceByIdUseCase.Input(name))).build();
    }

}
