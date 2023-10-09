package com.isa.bootcamp.entity;

public record Book(String author,
            String title,
            Category category,
            int pageCount,
            boolean forKids) {

    @Override
    public String toString() {
        return "{ " + author + ", " + title + " (" + pageCount + "str.) }";
    }
}
