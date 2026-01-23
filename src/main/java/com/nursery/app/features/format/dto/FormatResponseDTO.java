package com.nursery.app.features.format.dto;


public class FormatResponseDTO {
    private Integer formatId;
    private String formatName;
    private Boolean active;

    public FormatResponseDTO(){}

    public FormatResponseDTO(Integer formatId, String formatName, Boolean active){
        this.formatId=formatId;
        this.formatName=formatName;
        this.active=active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
