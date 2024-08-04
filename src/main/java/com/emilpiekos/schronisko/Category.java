package com.emilpiekos.schronisko;

public enum Category {
    CAT("cat"),
    DOG("dog"),
    OTHER("other");

    private String category;

    private Category(String category) {
        this.category = category;
    }

    public String convertEnumToString() {
        return category;
    }
}
