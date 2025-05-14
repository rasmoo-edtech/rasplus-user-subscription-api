package com.rasmoo.client.usersubscription.service;

import com.rasmoo.client.usersubscription.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    UserDto create(UserDto dto);

    UserDto uploadPhoto(Long id, MultipartFile file) throws IOException;

    byte[] downloadPhoto(Long id);
}
