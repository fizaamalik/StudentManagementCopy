package com.api.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.api.user.Permission.*;

@Getter
@RequiredArgsConstructor
public enum Role {
    GLOBAL(Set.of(
            COLLEGE_READ,
            COLLEGE_UPDATE,
            COLLEGE_CREATE,
            COLLEGE_DELETE,
            STUDENT_DELETE,
            STUDENT_CREATE,
            STUDENT_READ,
            STUDENT_UPDATE,
            GLOBAL_READ,
            GLOBAL_UPDATE,
            GLOBAL_CREATE,
            GLOBAL_DELETE
            )),
    COLLEGE(Set.of(
            COLLEGE_READ,
            COLLEGE_UPDATE,
            COLLEGE_CREATE,
            COLLEGE_DELETE,
            STUDENT_DELETE,
            STUDENT_CREATE,
            STUDENT_READ,
            STUDENT_UPDATE)),

    STUDENT(Set.of(
            STUDENT_DELETE,
            STUDENT_CREATE,
            STUDENT_READ,
            STUDENT_UPDATE));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
