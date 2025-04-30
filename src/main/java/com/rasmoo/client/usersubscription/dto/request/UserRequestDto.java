package com.rasmoo.client.usersubscription.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRequestDto(


        Long id,

        String name,

        String email,

        String phone,

        String cpf,

        LocalDate dtSubscription,

        LocalDate dtExpiration,

        String photoName,

        byte[] photo,

        UserTypeRequestDto userTypeRequestDto,

        SubscriptionTypeRequestDto subscriptionTypeRequestDto
) {
}
