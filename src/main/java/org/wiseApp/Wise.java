package org.wiseApp;

public class Wise {
    long id;
    String wiseName;

    String writer;

    public Wise(long id, String wiseName, String writer) {
        this.id = id;
        this.wiseName = wiseName;
        this.writer = writer;
    }

    public long getId() {
        return id;
    }

    public String getWiseName() {
        return wiseName;
    }

    public String getWriter() {
        return writer;
    }
}
