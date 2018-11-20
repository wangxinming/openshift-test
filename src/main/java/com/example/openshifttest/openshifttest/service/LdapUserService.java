package com.example.openshifttest.openshifttest.service;

import com.example.openshifttest.openshifttest.entity.LdapUser;

public interface LdapUserService {
    /**
     * Find user from LDAP
     * @param userName
     * @param password
     * @return
     */
    LdapUser findUser(String userName, String password);
}
