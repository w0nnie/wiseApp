package org.wiseApp.wise.entity;

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

    public void wiseUpdate(String wiseName,String writer) {
        this.wiseName = wiseName;
        this.writer = writer;
    }

    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "writer": "%s"
                }
                """
                .stripIndent()
                .formatted(id, wiseName, writer)
                .trim();
    }
}
