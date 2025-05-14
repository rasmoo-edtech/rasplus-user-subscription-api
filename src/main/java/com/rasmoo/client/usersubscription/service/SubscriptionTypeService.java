package com.rasmoo.client.usersubscription.service;


import com.rasmoo.client.usersubscription.dto.SubscriptionTypeDto;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionTypeDto> findAll();

    SubscriptionTypeDto findById(Long id);

    SubscriptionTypeDto create(SubscriptionTypeDto dto);

    SubscriptionTypeDto update(Long id, SubscriptionTypeDto dto);

    void delete(Long id);
}
