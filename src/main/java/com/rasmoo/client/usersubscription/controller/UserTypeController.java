package com.rasmoo.client.usersubscription.controller;

import com.rasmoo.client.usersubscription.dto.request.UserTypeRequestDto;
import com.rasmoo.client.usersubscription.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-type")
@RequiredArgsConstructor
public class UserTypeController {

    private final UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<List<UserTypeRequestDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userTypeService.findAll());
    }
}
