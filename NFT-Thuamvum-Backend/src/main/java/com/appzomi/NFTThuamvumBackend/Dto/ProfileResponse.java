package com.appzomi.NFTThuamvumBackend.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String role;
}
