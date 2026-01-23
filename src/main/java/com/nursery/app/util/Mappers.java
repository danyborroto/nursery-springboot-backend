package com.nursery.app.util;

import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.format.dto.FormatResponseDTO;
import com.nursery.app.features.format.entity.Format;
import com.nursery.app.features.format.repository.FormatRepository;
import com.nursery.app.features.product.dto.ProductResponseDTO;
import com.nursery.app.features.product.entity.Product;

public class Mappers {

    public static FormatResponseDTO ToFormatResponseDTO(Format format) {
        FormatResponseDTO responseDTO = new FormatResponseDTO(
                format.getFormatId(),
                format.getFormatName(),
                format.getActive());
        return responseDTO;
    }

    public static ProductResponseDTO toProductResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(product.getProductId());
        responseDTO.setProductName(product.getProductName());
        responseDTO.setProductPrice(product.getProductPrice());
        responseDTO.setProductDescription(product.getProductDescription());
        responseDTO.setProductCount(product.getProductCount());
        responseDTO.setProductHeight(product.getProductHeight());
        responseDTO.setProductHeightUnit(product.getProductHeightUnit());
        responseDTO.setFormat(product.getFormat().getFormatId());
        responseDTO.setActive(product.getActive());
        return responseDTO;
    }
}
