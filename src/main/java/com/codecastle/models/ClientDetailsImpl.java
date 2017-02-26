package com.codecastle.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClientDetailsImpl implements ClientDetails {


    private final Client client;

    public ClientDetailsImpl(Client client) {
        this.client = client;
    }


    @Override
    public String getClientId() {
        return client.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {

        return client.getSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        Set<String> scopes = new HashSet<>();
        scopes.add("openid");

        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        Set<AuthorizationType> result = client.getAuthorizationGrantTypes();
        Set<String> authorizationGrantTypes = new HashSet<>();

        for(AuthorizationType authorizationType:result) {
            authorizationGrantTypes.add(authorizationType.toString().toLowerCase().replace("_", "-"));
        }

        return authorizationGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return client.getRegisteredRedirectUri();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add((GrantedAuthority) () -> "ROLE_USER");
        return grantedAuthorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 60;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 86400;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
