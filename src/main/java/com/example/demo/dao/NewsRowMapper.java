package com.example.demo.dao;

import com.example.demo.model.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsRowMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet resultSet, int i) throws SQLException {
        News news = new News();

        news.setNews_id(resultSet.getLong("news_id"));
        news.setTitle(resultSet.getString("title"));
        news.setImageUrl(resultSet.getString("image_url"));
        news.setSummary(resultSet.getString("summary"));

        return news;
    }
}
