package com.rasmoo.client.usersubscription.dto;

import lombok.Builder;


@Builder
public record UserTypeDto(

        Long id,

        String name,

        String description
) {
}
