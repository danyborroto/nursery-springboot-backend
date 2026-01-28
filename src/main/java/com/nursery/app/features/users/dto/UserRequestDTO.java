package com.nursery.app.features.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String userName;
    private String userPassword;
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es valido")
    private String userEmail;
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe tener entre 9 y 15 dígitos"
    )
    private String userPhone;
    private Boolean admin;
    private Boolean active;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String userName, String userPassword, String userEmail, String userPhone, Boolean admin, Boolean active) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.admin = admin;
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
