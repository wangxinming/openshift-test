package com.example.openshifttest.openshifttest.entity;

import lombok.Data;

@Data
public class LdapUser {
    private String userName;
    private String displayName;
    private String cn;
}
