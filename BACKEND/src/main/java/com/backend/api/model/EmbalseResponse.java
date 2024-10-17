package com.backend.api.model;

import java.util.List;


public class EmbalseResponse {
    private List<Embalse> items;
    private String next; // This would store the URL of the next page if pagination is supported

    public List<Embalse> getItems() {
        return items;
    }

    public void setItems(List<Embalse> items) {
        this.items = items;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
