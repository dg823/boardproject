package com.example.boardproject.controller;

import com.example.boardproject.dto.ArticleForm;
import com.example.boardproject.entity.Article;
import com.example.boardproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    // 1. 새 글 작성 페이지
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    // 2. 새 글 등록 (리다이렉트 적용)
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        // 상세 페이지로 리다이렉트
        return "redirect:/articles/" + saved.getId();
    }

    // 3. 상세 조회 페이지
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/show";
    }

    // 4. 목록 조회 페이지
    @GetMapping("/articles")
    public String index(Model model) {
        List<Article> articleList = (List<Article>) articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "articles/index";
    }
}
