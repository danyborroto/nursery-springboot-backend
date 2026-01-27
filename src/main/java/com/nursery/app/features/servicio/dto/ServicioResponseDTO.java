package com.nursery.app.features.servicio.dto;

public class ServicioResponseDTO {
    private Integer serviceId;
    private String serviceName;
    private Boolean selectable;
    private Boolean active;

    public ServicioResponseDTO() {}

    public ServicioResponseDTO(Integer serviceId, String serviceName, Boolean selectable, Boolean active) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.selectable = selectable;
        this.active = active;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
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
