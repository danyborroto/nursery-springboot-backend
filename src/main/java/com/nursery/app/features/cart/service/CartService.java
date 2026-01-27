package com.nursery.app.features.cart.service;

import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.cart.dto.CartRequestDTO;
import com.nursery.app.features.cart.dto.CartResponseDTO;
import com.nursery.app.features.cart.entity.Cart;
import com.nursery.app.features.cart.repository.CartRepository;
import com.nursery.app.features.cart_product.dto.CartProductRequestDTO;
import com.nursery.app.features.cart_product.dto.CartProductResponseDTO;
import com.nursery.app.features.cart_product.entity.CartProduct;
import com.nursery.app.features.cart_product.entity.CartProductId;
import com.nursery.app.features.cart_product.repository.CartProductRepository;
import com.nursery.app.features.product.dto.ProductResponseDTO;
import com.nursery.app.features.product.entity.Product;
import com.nursery.app.features.product.repository.ProductRepository;
import com.nursery.app.util.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartProductRepository cartProductRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<List<CartResponseDTO>> getAll() {
        List<CartResponseDTO> cartResponseDTOS = cartRepository.findAll().stream()
                .map(Mappers::toCartResponseDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(cartResponseDTOS);
    }

    public ResponseEntity<CartResponseDTO> getOne(Integer cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new FeatureNotFoundException("Cart", cartId));
        List<CartProductResponseDTO> cartProductResponseDTOS = cartProductRepository.findByCart_CartId(cartId).stream()
                .map(Mappers::toCartProductResponseDTO)
                .toList();
        CartResponseDTO res = Mappers.toCartResponseDTO(cart);
        res.setProducts(cartProductResponseDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    public ResponseEntity<CartResponseDTO> create(CartRequestDTO requestDTO) {
        Cart cart = new Cart();
        cart.setUserId(requestDTO.getUserId());
        cart.setActive(true);
        Cart saved = cartRepository.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toCartResponseDTO(saved));
    }
    public ResponseEntity<Void> delete(Integer cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new FeatureNotFoundException("Cart", cartId));
        cart.setActive(false);
        Cart saved = cartRepository.save(cart);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<CartProductResponseDTO> addProduct(Integer cartId, Integer productId, CartProductRequestDTO requestDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Product", productId));
        Cart cart = cartRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Cart", cartId));

        CartProduct cartProduct = new CartProduct();
        cartProduct.setCart(cart);
        cartProduct.setCartProductId(new CartProductId(cart.getCartId(), product.getProductId()));
        cartProduct.setProduct(product);
        cartProduct.setPrice(product.getProductPrice());
        cartProduct.setQuantity(requestDTO.getQuantity());

        CartProduct saved = cartProductRepository.save(cartProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toCartProductResponseDTO(saved));
    }

    public ResponseEntity<CartProductResponseDTO> updateProduct(Integer cartId, Integer productId, CartProductRequestDTO requestDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Product", productId));
        Cart cart = cartRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Cart", cartId));

        CartProduct cartProduct = cartProductRepository.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), product.getProductId())
                .orElseThrow(() -> new FeatureNotFoundException("Product on Cart", product.getProductId()));
        cartProduct.setQuantity(requestDTO.getQuantity());
        CartProduct saved = cartProductRepository.save(cartProduct);
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toCartProductResponseDTO(saved));
    }

    public ResponseEntity<Void> deleteProduct(Integer cartId, Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Product", productId));
        Cart cart = cartRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Cart", cartId));

        CartProduct cartProduct = cartProductRepository.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), product.getProductId())
                .orElseThrow(() -> new FeatureNotFoundException("Product on Cart", product.getProductId()));
        cartProductRepository.delete(cartProduct);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
