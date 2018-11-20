package com.example.openshifttest.openshifttest.service.impl;

import com.example.openshifttest.openshifttest.entity.LdapUser;
import com.example.openshifttest.openshifttest.service.LdapUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
@Slf4j
public class LdapUserServiceImpl implements LdapUserService{
    @Autowired
    private LdapTemplate ldapTemplate;

    @Value("${spring.ldap.username}")
    private String adminUserName;

    @Value("${spring.ldap.password}")
    private String adminSecret;
    private String extractAccountName(String userName) {
        return userName.substring(0, userName.indexOf("@"));
    }
    @Override
    public LdapUser findUser(String userName, String password) {
        LdapUser ldapUser = null;
        DirContext ctx = null;
        try {
            // 必须设置，否则会有PartialResultException
            ldapTemplate.setIgnorePartialResultException(true);
            //使用用户名、密码验证域用户
//            ldapTemplate.list("DC=fosun,DC=com");
            ctx = ldapTemplate.getContextSource().getContext(userName, password);
            //如果验证成功根据sAMAccountName属性查询用户名和用户所属的组
            List<LdapUser> ldapUsers = ldapTemplate.search(
                    query().
                            where("objectclass").is("person").
                            and("sAMAccountName").is(extractAccountName(userName)),

                    (Attributes attributes) -> {
                        LdapUser person = new LdapUser();
                        person.setUserName(userName);
                        person.setDisplayName(attributes.get("cn").get().toString());
                        return person;
                    });
            if (ldapUsers == null || ldapUsers.size() == 0) {
                log.warn("Cannot find LDAP user info for: " + userName);
                return null;
            }
            ldapUser = ldapUsers.get(0);
        } catch (Exception ex) {
            log.error("Failed to fetch LDAP user info for: " + userName, ex);
        } finally {
            if (ctx != null) {
                //关闭ldap连接
                LdapUtils.closeContext(ctx);
            }
        }
        return ldapUser;
    }
}
