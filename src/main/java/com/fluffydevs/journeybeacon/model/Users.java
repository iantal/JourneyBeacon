package com.fluffydevs.journeybeacon.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

@Data
public final class Users {
    @Id
    @JsonIgnore
    private Integer id;

    private String email;
    private String displayName;
    private String idToken;
    private String userId;

    @PersistenceCreator
    @JsonCreator
    public Users(String email, String displayName, String idToken, String userId) {
        this.email = email;
        this.displayName = displayName;
        this.idToken = idToken;
        this.userId = userId;
    }

    public boolean isComplete() {
        return !"".equals(email) && !"".equals(displayName) && !"".equals(idToken) && !"".equals(userId);
    }
}
