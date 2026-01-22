package com.nursery.app.features.format.dto;

import jakarta.validation.constraints.NotBlank;

public class FormatRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String formatName;
    private Boolean activa;

    public FormatRequestDTO(){}
    public FormatRequestDTO(String formatName, Boolean activa) {
        this.formatName = formatName;
        this.activa = activa;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
