package com.nursery.app.features.servicio.dto;

import jakarta.validation.constraints.NotBlank;

public class ServicioRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String serviceName;
    private Boolean selectable;
    private Boolean active;

    public ServicioRequestDTO() {}

    public ServicioRequestDTO(String serviceName, Boolean selectable, Boolean active) {
        this.serviceName = serviceName;
        this.selectable = selectable;
        this.active = active;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
