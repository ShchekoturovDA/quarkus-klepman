package com.shchek.pets.resource;

import com.shchek.pets.service.WarehouseService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/warehouse")
public class WarehouseResource {

    WarehouseService warehouseService;

    @POST
    @Path("/addNew")
    public Response addNewWareHouse(String address) {
        warehouseService.addNew(address);
        return Response.ok().build();
    }

}
