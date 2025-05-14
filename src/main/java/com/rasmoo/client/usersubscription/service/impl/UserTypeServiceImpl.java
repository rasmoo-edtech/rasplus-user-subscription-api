package com.rasmoo.client.usersubscription.service.impl;

import com.rasmoo.client.usersubscription.dto.UserTypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<UserTypeDto> findAll() {
        return userTypeRepository.findAll();
    }
}
