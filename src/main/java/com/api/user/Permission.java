package com.api.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    GLOBAL_READ("global:read"),
    GLOBAL_UPDATE("global:update"),
    GLOBAL_CREATE("global:create"),
    GLOBAL_DELETE("global:delete"),
    COLLEGE_READ("college:read"),
    COLLEGE_UPDATE("college:update"),
    COLLEGE_CREATE("college:create"),
    COLLEGE_DELETE("college:delete"),
    STUDENT_READ("student:read"),
    STUDENT_UPDATE("student:update"),
    STUDENT_CREATE("student:create"),
    STUDENT_DELETE("student:delete")
    ;
    @Getter
    private final String permission;



}
