package com.shchek.pets.resource;

import com.shchek.pets.dto.AddProductCountDTO;
import com.shchek.pets.dto.AddProductDTO;
import com.shchek.pets.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/product")
public class ProductResource {

    @Inject
    ProductService productService;

    @POST
    @Path("/addNew")
    public Response addNewProduct(AddProductDTO addProductDTO) {
        productService.addNewProduct(addProductDTO);
        return Response.ok().build();
    }

    @POST
    @Path("/addMore")
    public Response addNewProduct(AddProductCountDTO addMoreProductDTO) {
        productService.addMoreProducts(addMoreProductDTO);
        return Response.ok().build();
    }

}
