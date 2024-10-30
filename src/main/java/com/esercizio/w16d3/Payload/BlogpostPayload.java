package com.esercizio.w16d3.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogpostPayload {
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
    private int authorId;

    public void setCover(String url) {
    }
}
