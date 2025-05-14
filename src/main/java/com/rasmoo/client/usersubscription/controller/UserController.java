package com.rasmoo.client.usersubscription.controller;

import com.rasmoo.client.usersubscription.dto.UserDto;
import com.rasmoo.client.usersubscription.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @PatchMapping(value = "/{id}/upload-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> uploadPhoto(@PathVariable("id") Long id, @RequestPart("file") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.uploadPhoto(id, file));
    }


    @GetMapping(value = "/{id}/photo", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.downloadPhoto(id));
    }

}
