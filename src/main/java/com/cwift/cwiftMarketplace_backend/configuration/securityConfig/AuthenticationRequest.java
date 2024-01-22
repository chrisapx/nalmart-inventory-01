package com.cwift.cwiftMarketplace_backend.configuration.securityConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    String username;
    String password;
}
