package com.nursery.app.features.format.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class FormatRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String formatName;
    @NotNull(message = "El campo es obligatorio")
    private Boolean active;

    public FormatRequestDTO(){}
    public FormatRequestDTO(String formatName, Boolean active) {
        this.formatName = formatName;
        this.active = active;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
