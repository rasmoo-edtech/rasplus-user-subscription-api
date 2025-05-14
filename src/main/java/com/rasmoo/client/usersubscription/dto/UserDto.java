package com.rasmoo.client.usersubscription.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserDto(


        Long id,

        String name,

        String email,

        String phone,

        String cpf,

        LocalDate dtSubscription,

        LocalDate dtExpiration,

        String photoName,

        byte[] photo,

        UserTypeDto userTypeRequestDto,

        SubscriptionTypeDto subscriptionTypeRequestDto
) {
}
