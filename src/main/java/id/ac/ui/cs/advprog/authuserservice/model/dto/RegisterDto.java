package id.ac.ui.cs.advprog.authuserservice.model.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String type;
}