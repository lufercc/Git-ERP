package com.jalasoft.automation.core.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mauricio on 5/26/2015.
 */
public class UserCredentials {
    public String email;
    public String userName;
    public String password;
    public List<String> credentialTypes;

    public UserCredentials(String email, String userName, String password, String type) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        credentialTypes = new ArrayList<>();
        credentialTypes.add(type);
    }

    public void addCredentialType(String type) {
        if (!this.credentialTypes.contains(type)) {
            this.credentialTypes.add(type);
        }
    }
}
