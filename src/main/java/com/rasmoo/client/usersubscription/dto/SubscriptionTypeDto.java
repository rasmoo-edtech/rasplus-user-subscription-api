package com.rasmoo.client.usersubscription.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SubscriptionTypeDto(
        Long id,

        String name,

        Long accessMonths,

        BigDecimal price,

        String productKey) {
}
