package com.nursery.app.features.users.dto;

public class UserResponseDTO {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private Boolean admin;
    private Boolean active;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer userId, String userName, String userEmail, String userPhone, Boolean admin, Boolean active) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.admin = admin;
        this.active = active;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
