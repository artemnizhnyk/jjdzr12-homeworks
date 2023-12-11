package com.isa.bootcamp.entity;
public enum SortOrFilterOption {
    DEFAULT("Default"),
    FILTER_BY_MAX_PRIORITY("With max priority"),
    FILTER_WITH_NEXT_DAY_CONDITION("Tomorrow"),
    SORT_FROM_MAX_TO_MIN_PRIORITY("From max to min priority"),
    SORT_FROM_NEAREST_TO_LATEST_DATE("From nearest to latest date"),
    FILTER_BY_CATEGORY_WORK("By Category: Work"),
    FILTER_BY_CATEGORY_HOME("By Category: Home"),
    FILTER_BY_CATEGORY_SELF_CARE("By Category: Self-care"),
    FILTER_BY_CATEGORY_SPORT("By Category: Sport"),
    FIND_THE_MOST_IMPORTANT_TASK("The most important task")
    ;

    private String displayName;

    SortOrFilterOption(final String string) {
        this.displayName = string;
    }

    public String getDisplayName() {
        return displayName;
    }
}
