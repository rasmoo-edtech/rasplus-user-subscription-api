package com.rasmoo.client.usersubscription.dto.request;

import lombok.Builder;


@Builder
public record UserTypeRequestDto(

        Long id,

        String name,

        String description
) {
}
