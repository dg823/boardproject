package com.example.boardproject.dto;

import com.example.boardproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @Slf4j
public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(title, content);
    }

    public void logInfo() {
        log.info("title: {}, content: {}", title, content);
    }
}

