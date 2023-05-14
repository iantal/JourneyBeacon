package com.fluffydevs.journeybeacon.model;

import lombok.Data;

@Data
public class ResponseError extends Response {
    private String message = "error";
}
