package com.develop.thankyounext.domain.dto.base.common;

import com.develop.thankyounext.domain.enums.UserRoleEnum;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
public record AuthenticationDto(
        Long id,
        String username,
        Collection<? extends GrantedAuthority> authorities
) implements UserDetails {
    @Override
    public Long id() {
        return id;
    }

    @Builder
    public AuthenticationDto {
        if (Objects.isNull(authorities)) {
            authorities = Set.of(UserRoleEnum.GUEST).stream()
                    .map(UserRoleEnum::getAuthority)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toUnmodifiableSet());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


