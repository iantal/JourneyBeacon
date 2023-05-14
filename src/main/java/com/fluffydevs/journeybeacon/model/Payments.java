package com.fluffydevs.journeybeacon.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

@Data
public class Payments {
    @Id
    @JsonIgnore
    private Integer id;

    private String userId;
    private String timestmp;
    private String amount;
    private String route;

    @PersistenceCreator
    @JsonCreator
    public Payments(String userId, String timestmp, String amount, String route) {
        this.userId = userId;
        this.timestmp = timestmp;
        this.amount = amount;
        this.route = route;
    }
}
