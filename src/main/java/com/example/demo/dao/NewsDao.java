package com.example.demo.dao;

import com.example.demo.model.News;

import java.util.List;

public interface NewsDao {

    List<News> findAll();

    News findById(Long id);

    void update(News news);
}
