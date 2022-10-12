package com.bookshop.bookshop.dtos.auth;

import com.bookshop.bookshop.dtos.user.CreateUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {

    private String token;
    private CreateUserDto userDto;

}
