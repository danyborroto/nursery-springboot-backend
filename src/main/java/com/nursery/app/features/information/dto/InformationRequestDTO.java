package com.nursery.app.features.information.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class InformationRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nurseryName;
    private String description;
    private String history;
    private String address;
    @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe tener entre 9 y 15 dígitos"
    )
    private String phonePrimary;
    @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe tener entre 9 y 15 dígitos"
    )
    private String phoneSecondary;
    @Email(message = "El email no es valido")
    private String email;

    public InformationRequestDTO() {
    }

    public String getNurseryName() {
        return nurseryName;
    }

    public void setNurseryName(String nurseryName) {
        this.nurseryName = nurseryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonePrimary() {
        return phonePrimary;
    }

    public void setPhonePrimary(String phonePrimary) {
        this.phonePrimary = phonePrimary;
    }

    public String getPhoneSecondary() {
        return phoneSecondary;
    }

    public void setPhoneSecondary(String phoneSecondary) {
        this.phoneSecondary = phoneSecondary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
