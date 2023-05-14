package com.fluffydevs.journeybeacon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDetails {
    private String timestmp;
    private String amount;
    private String route;
}
