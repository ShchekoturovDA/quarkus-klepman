package com.shchek.pets.service;

import com.shchek.pets.dto.AddProductCountDTO;
import com.shchek.pets.dto.AddProductDTO;
import com.shchek.pets.mapper.ProductMapper;
import com.shchek.pets.model.Product;
import com.shchek.pets.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductMapper productMapper;

    public void addNewProduct(AddProductDTO addProductDTO) {
        productRepository.persistAndFlush(productMapper.productDtoToEntity(addProductDTO));
    }

    @Transactional(rollbackOn = Exception.class)
    public void addMoreProducts(AddProductCountDTO addMoreProductDTO) {
        for (var pair : addMoreProductDTO.getProductsCounts()) {
            Product product = productRepository.findBySysName(pair.getKey());
            if (product == null) {
                throw new BadRequestException(String.format("Продукта с наименованием %s не существует", pair.getKey()));
            }

            product.totalCount += pair.getRight();
            product.persistAndFlush();
        }
    }
}
