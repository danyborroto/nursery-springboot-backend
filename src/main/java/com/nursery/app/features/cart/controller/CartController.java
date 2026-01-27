package com.nursery.app.features.cart.controller;

import com.nursery.app.features.cart.dto.CartRequestDTO;
import com.nursery.app.features.cart.dto.CartResponseDTO;
import com.nursery.app.features.cart.service.CartService;
import com.nursery.app.features.cart_product.dto.CartProductRequestDTO;
import com.nursery.app.features.cart_product.dto.CartProductResponseDTO;
import com.nursery.app.features.cart_servicio.dto.CartServicioRequestDTO;
import com.nursery.app.features.cart_servicio.dto.CartServicioResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    public final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<CartResponseDTO>> getAll() {
        return cartService.getAll();
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartResponseDTO> getOne(@PathVariable Integer cartId) {
        return cartService.getOne(cartId);
    }

    @PostMapping
    public ResponseEntity<CartResponseDTO> create(@Valid @RequestBody CartRequestDTO requestDTO) {
        return cartService.create(requestDTO);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> delete(@PathVariable Integer cartId) {
        return cartService.delete(cartId);
    }

    @PostMapping("/{cartId}/item/{productId}")
    public ResponseEntity<CartProductResponseDTO> addProduct(@PathVariable Integer cartId, @PathVariable Integer productId, @Valid @RequestBody CartProductRequestDTO requestDTO) {
        return cartService.addProduct(cartId, productId, requestDTO);
    }

    @PutMapping("/{cartId}/item/{productId}")
    public ResponseEntity<CartProductResponseDTO> updateProduct(@PathVariable Integer cartId, @PathVariable Integer productId, @Valid @RequestBody CartProductRequestDTO requestDTO) {
        return cartService.updateProduct(cartId, productId, requestDTO);
    }

    @DeleteMapping("/{cartId}/item/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer cartId, @PathVariable Integer productId) {
        return cartService.deleteProduct(cartId, productId);
    }

    @PostMapping("/{cartId}/service/{servicioId}")
    public ResponseEntity<CartServicioResponseDTO> addServicio(@PathVariable Integer cartId, @PathVariable Integer servicioId, @Valid @RequestBody CartServicioRequestDTO dto){
        return cartService.addService(cartId,servicioId,dto);
    }
    @PutMapping("/{cartId}/service/{servicioId}")
    public ResponseEntity<CartServicioResponseDTO> updateServicio(@PathVariable Integer cartId, @PathVariable Integer servicioId, @Valid @RequestBody CartServicioRequestDTO dto){
        return cartService.updateService(cartId,servicioId,dto);
    }

    @DeleteMapping("/{cartId}/service/{servicioId}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Integer cartId, @PathVariable Integer servicioId){
        return cartService.deleteService(cartId,servicioId);
    }
}
