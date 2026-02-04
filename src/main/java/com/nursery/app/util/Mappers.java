package com.nursery.app.util;

import com.nursery.app.features.cart.dto.CartResponseDTO;
import com.nursery.app.features.cart.entity.Cart;
import com.nursery.app.features.cart_product.dto.CartProductResponseDTO;
import com.nursery.app.features.cart_product.entity.CartProduct;
import com.nursery.app.features.cart_servicio.dto.CartServicioResponseDTO;
import com.nursery.app.features.cart_servicio.entity.CartServicio;
import com.nursery.app.features.format.dto.FormatResponseDTO;
import com.nursery.app.features.format.entity.Format;
import com.nursery.app.features.format.repository.FormatRepository;
import com.nursery.app.features.information.dto.InformationResponseDTO;
import com.nursery.app.features.information.entity.Information;
import com.nursery.app.features.invoice.dto.InvoiceResponseDTO;
import com.nursery.app.features.invoice.entity.Invoice;
import com.nursery.app.features.invoice_product.dto.InvoiceProductResponseDTO;
import com.nursery.app.features.invoice_product.entity.InvoiceProduct;
import com.nursery.app.features.invoice_servicio.dto.InvoiceServiceResponseDTO;
import com.nursery.app.features.invoice_servicio.entity.InvoiceServiceEntity;
import com.nursery.app.features.product.dto.ProductResponseDTO;
import com.nursery.app.features.product.entity.Product;
import com.nursery.app.features.servicio.dto.ServicioResponseDTO;
import com.nursery.app.features.servicio.entity.Servicio;
import com.nursery.app.features.users.dto.UserResponseDTO;
import com.nursery.app.features.users.entity.User;

import java.util.List;

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

    public static CartResponseDTO toCartResponseDTO(Cart cart) {
        List<CartProductResponseDTO> productos = cart.getCartProducts().stream()
                .map(Mappers::toCartProductResponseDTO)
                .toList();
        List<CartServicioResponseDTO> servicios = cart.getCartServicios().stream()
                .map(Mappers::toCartServicioResponseDTO)
                .toList();

        CartResponseDTO responseDTO = new CartResponseDTO();
        responseDTO.setCartId(cart.getCartId());
        responseDTO.setUserId(cart.getUserId());
        responseDTO.setActive(cart.getActive());
        responseDTO.setProducts(productos);
        responseDTO.setServicios(servicios);
        return responseDTO;
    }

    public static CartProductResponseDTO toCartProductResponseDTO(CartProduct cartProduct) {
        CartProductResponseDTO dto = new CartProductResponseDTO();
        dto.setCartId(cartProduct.getCartProductId().getCartId());
        dto.setProductId(cartProduct.getCartProductId().getProductId());
        dto.setPrice(cartProduct.getPrice());
        dto.setQuantity(cartProduct.getQuantity());
        return dto;
    }

    // Mappers de servicios
    public static ServicioResponseDTO toServicioResponseDTO(Servicio servicio) {
        ServicioResponseDTO servicioResponseDTO = new ServicioResponseDTO();
        servicioResponseDTO.setServiceId(servicio.getServiceId());
        servicioResponseDTO.setServiceName(servicio.getServiceName());
        servicioResponseDTO.setSelectable(servicio.getSelectable());
        servicioResponseDTO.setActive(servicio.getActive());
        return servicioResponseDTO;
    }

    /**
     * Mapper CartServicio to CartServicioResponseDTO
     *
     * @param cartServicio
     * @return
     */
    public static CartServicioResponseDTO toCartServicioResponseDTO(CartServicio cartServicio) {
        CartServicioResponseDTO responseDTO = new CartServicioResponseDTO();
        responseDTO.setId(cartServicio.getId());
        responseDTO.setCartId(cartServicio.getCart().getCartId());
        responseDTO.setServiceId(cartServicio.getServicio().getServiceId());
        responseDTO.setPrice(cartServicio.getPrice());
        return responseDTO;
    }

    public static UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO res = new UserResponseDTO();
        res.setUserName(user.getUserName());
        res.setUserId(user.getUserId());
        res.setUserEmail(user.getUserEmail());
        res.setUserPhone(user.getUserPhone());
        res.setAdmin(user.getAdmin());
        res.setActive(user.getActive());
        return res;
    }

    public static InformationResponseDTO toInfoResponseDTO(Information info){
        InformationResponseDTO res = new InformationResponseDTO();
        res.setInfoId(info.getInfoId());
        res.setNurseryName(info.getNurseryName());
        res.setDescription(info.getDescription());
        res.setHistory(info.getHistory());
        res.setAddress(info.getAddress());
        res.setEmail(info.getEmail());
        res.setPhonePrimary(info.getPhonePrimary());
        res.setPhoneSecondary(info.getPhoneSecondary());

        return res;
    }

    public static InvoiceResponseDTO toInvoiceResponseDTO(Invoice invoice) {
        List<InvoiceProductResponseDTO> productos = invoice.getInvoiceProducts().stream()
                .map(Mappers::toInvoiceProductResponseDTO)
                .toList();
        List<InvoiceServiceResponseDTO> servicios = invoice.getInvoiceServicios().stream()
                .map(Mappers::toInvoiceServicioResponseDTO)
                .toList();

        InvoiceResponseDTO responseDTO = new InvoiceResponseDTO();
        responseDTO.setInvoiceId(invoice.getInvoiceId());
        responseDTO.setUserId(invoice.getUser().getUserId());
        responseDTO.setProducts(productos);
        responseDTO.setServicios(servicios);
        responseDTO.setAddress(invoice.getAddress());
        responseDTO.setInvoiceStatus(invoice.getInvoiceStatus());
        responseDTO.setDateOrder(invoice.getDateOrder());
        responseDTO.setInvoiceDate(invoice.getInvoiceDate());
        return responseDTO;
    }

    public static InvoiceProductResponseDTO toInvoiceProductResponseDTO(InvoiceProduct invoiceProduct) {
        InvoiceProductResponseDTO dto = new InvoiceProductResponseDTO();
        dto.setId(invoiceProduct.getId());
        dto.setInvoiceId(invoiceProduct.getInvoice().getInvoiceId());
        dto.setProductId(invoiceProduct.getProduct().getProductId());
        dto.setPrice(invoiceProduct.getPrice());
        dto.setCount(invoiceProduct.getCount());
        return dto;
    }
    public static InvoiceServiceResponseDTO toInvoiceServicioResponseDTO(InvoiceServiceEntity invoiceServicio) {
        InvoiceServiceResponseDTO responseDTO = new InvoiceServiceResponseDTO();
        responseDTO.setId(invoiceServicio.getId());
        responseDTO.setInvoiceId(invoiceServicio.getInvoice().getInvoiceId());
        responseDTO.setPrice(invoiceServicio.getPrice());
        responseDTO.setServiceId(invoiceServicio.getServicio().getServiceId());
        return responseDTO;
    }

}
