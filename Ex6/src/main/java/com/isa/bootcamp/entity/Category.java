package com.isa.bootcamp.entity;

public enum Category {

    KRYMINAL_SENSACJA_THRILLER("Crime-Sentation-Thriller"),
    LITERATURA_PIEKNA("Belles-Letters"),
    HISTORYCZNA("Historical"),
    FANTASTYKA_SCIENCE_FICTION("Science Fiction"),
    PUBLICYSTYKA_BIOGRAFIA("Publishing Biography"),
    OBYCZAJOWA_ROMANS("Customs-Romance");

    private String displayName;

    Category(final String string) {
        this.displayName = string;
    }

    public String getDisplayName() {
        return displayName;
    }
}
