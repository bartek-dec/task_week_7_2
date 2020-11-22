package com.example.demo.dao;

import com.example.demo.model.News;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NewsDaoImpl implements NewsDao {

    private JdbcTemplate jdbcTemplate;

    public NewsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<News> findAll() {
        String sql = "SELECT * FROM news";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        List<News> foundNews = new ArrayList<>();

        maps.stream().forEach(element -> {
            News news = new News();
            news.setNews_id(Long.parseLong(String.valueOf(element.get("news_id"))));
            news.setTitle(String.valueOf(element.get("title")));
            news.setImageUrl(String.valueOf(element.get("image_url")));
            news.setSummary(String.valueOf(element.get("summary")));

            foundNews.add(news);
        });

        return foundNews;
    }

    @Override
    public News findById(Long id) {
        String sql = "SELECT * FROM news WHERE news_id = ?";
        News news = jdbcTemplate.queryForObject(sql, new NewsRowMapper(), id);

        return news;
    }

    @Override
    public void update(News news) {
        String sql = "UPDATE news SET title = ?, summary = ? WHERE news_id = ?";
        jdbcTemplate.update(sql, news.getTitle(), news.getSummary(), news.getNews_id());
    }
}
