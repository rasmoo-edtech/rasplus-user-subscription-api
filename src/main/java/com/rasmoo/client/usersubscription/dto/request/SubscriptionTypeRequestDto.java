package com.rasmoo.client.usersubscription.dto.request;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SubscriptionTypeRequestDto(
        Long id,

        String name,

        Long accessMonths,

        BigDecimal price,

        String productKey) {
}
