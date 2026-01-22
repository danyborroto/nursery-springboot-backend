package com.nursery.app.features.format.dto;

public class FormatResponseDTO {
    private Integer formatId;
    private String formatName;
    private Boolean activa;

    public FormatResponseDTO(){}

    public FormatResponseDTO(Integer formatId, String formatName, Boolean activa){
        this.formatId=formatId;
        this.formatName=formatName;
        this.activa=activa;
    }

    public Integer getFormatId() {
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
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
