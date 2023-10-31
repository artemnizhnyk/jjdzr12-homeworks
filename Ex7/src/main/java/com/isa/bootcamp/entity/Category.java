package com.isa.bootcamp.entity;

public enum Category {

    HOME("Home"),
    WORK("Work"),
    SELF_CARE("Self care"),
    SPORT("Sport");

    private String displayName;

    Category(final String string) {
        this.displayName = string;
    }

    public String getDisplayName() {
        return displayName;
    }
}
