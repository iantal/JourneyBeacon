package com.fluffydevs.journeybeacon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    private String displayName;
    private String userId;
}
