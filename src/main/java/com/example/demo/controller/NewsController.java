package com.example.demo.controller;

import com.example.demo.dao.NewsDao;
import com.example.demo.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {

    private NewsDao newsDao;

    @Autowired
    public NewsController(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @GetMapping("/")
    public String findAllNews(Model model) {
        model.addAttribute("news", newsDao.findAll());

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String displayEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("foundNews", newsDao.findById(id));

        return "edit";
    }

    @PostMapping("/edit")
    public String updateNews(News news) {
        newsDao.update(news);

        return "redirect:/";
    }
}
