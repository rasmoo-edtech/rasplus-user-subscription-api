package com.rasmoo.client.usersubscription.service.impl;

import com.rasmoo.client.usersubscription.dto.UserDto;
import com.rasmoo.client.usersubscription.dto.UserTypeDto;
import com.rasmoo.client.usersubscription.exception.BadRequestException;
import com.rasmoo.client.usersubscription.exception.NotFoudException;
import com.rasmoo.client.usersubscription.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private static final String PNG = ".png";
    private static final String JPEG = ".jpeg";

    private final UserRepository userRepository;

    private final UserTypeRepository userTypeRepository;


    UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserDto create(UserDto dto) {

        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("id deve ser nulo");
        }

        var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());

        if (userTypeOpt.isEmpty()) {
            throw new NotFoudException("userTypeId não encontrado");
        }

        UserTypeDto userType = userTypeOpt.get();
        UserDto user = UserMapper.fromDtoToEntity(dto, userType, null);
        return userRepository.save(user);
    }

    @Override
    public UserDto uploadPhoto(Long id, MultipartFile file) throws IOException {
        String imgName = file.getOriginalFilename();
        String formatPNG =  imgName.substring(imgName.length() - 4);
        String formatJPEG =  imgName.substring(imgName.length() - 5);
        if (!(PNG.equalsIgnoreCase(formatPNG) || JPEG.equalsIgnoreCase(formatJPEG))) {
            throw new BadRequestException("Imagem deve possuir formato JPEG ou PNG.");
        }
        UserDto user = findById(id);
        user.setPhotoName(file.getOriginalFilename());
        user.setPhoto(file.getBytes());
        return userRepository.save(user);
    }

    @Override
    public byte[] downloadPhoto(Long id) {
        UserDto user = findById(id);
        if (Objects.isNull(user.getPhoto())) {
            throw new BadRequestException("Usuário não possui foto");
        }
        return user.getPhoto();
    }

    private UserDto findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoudException("Usuário não encontrado"));
    }
}
