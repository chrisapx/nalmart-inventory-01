package com.cwift.cwiftMarketplace_backend.configuration.securityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true/*, jsr250Enabled = true, prePostEnabled = true*/)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

//    for skipping the ROLE_ during roles check for @PreAuthorise annotation
//    @Bean
//    GrantedAuthorityDefaults grantedAuthorityDefaults(){
//        return new GrantedAuthorityDefaults("");
//    }

    //for skipping the ROLE_ check on authorities while using the @Secured annotation
    @Override
    protected AccessDecisionManager accessDecisionManager(){
        AffirmativeBased accessDecisionManager = (AffirmativeBased) super.accessDecisionManager();
        setAuthRolePrefix(accessDecisionManager, "");
        return accessDecisionManager;
    }

    private void setAuthRolePrefix(AffirmativeBased accessDecisionManager, String rolePrefix){
        accessDecisionManager.getDecisionVoters().stream()
                .filter(RoleVoter.class :: isInstance)
                .map(RoleVoter.class :: cast)
                .forEach(it -> it.setRolePrefix(rolePrefix));
    }
}
