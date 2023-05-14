package com.fluffydevs.journeybeacon.model;

import lombok.Data;

@Data
public class ResponseOk extends Response {
    private String message = "ok";
}
