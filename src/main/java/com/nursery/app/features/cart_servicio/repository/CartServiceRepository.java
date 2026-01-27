package com.nursery.app.features.cart_servicio.repository;

import com.nursery.app.features.cart_servicio.entity.CartServicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartServiceRepository extends JpaRepository<CartServicio, Integer> {
    Optional<CartServicio> findByCartCartIdAndServicioServiceId(Integer cartId, Integer servicioId);
}
