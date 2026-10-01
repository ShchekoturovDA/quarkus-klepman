package com.shchek.pets.mapper;

import com.shchek.pets.dto.AddProductDTO;
import com.shchek.pets.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public abstract class ProductMapper {

    public abstract Product productDtoToEntity(AddProductDTO addProductDTO);
}
