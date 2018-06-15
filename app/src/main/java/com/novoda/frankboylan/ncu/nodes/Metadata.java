package com.novoda.frankboylan.ncu.nodes;

class Metadata {
    
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "title='" + title + '\'' +
                '}';
    }
}
