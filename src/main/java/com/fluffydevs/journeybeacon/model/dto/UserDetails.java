package com.fluffydevs.journeybeacon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDetails {
    private String displayName;
    private List<PaymentDetails> payments;
}
