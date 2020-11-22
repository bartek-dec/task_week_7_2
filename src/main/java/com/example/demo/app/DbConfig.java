package com.example.demo.app;

import com.example.demo.api.NewsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource dataSource;
    private NewsApi newsApi;

    @Autowired
    public DbConfig(DataSource dataSource, NewsApi newsApi) {
        this.dataSource = dataSource;
        this.newsApi = newsApi;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        String dropTable = "DROP TABLE IF EXISTS news";
        getJdbcTemplate().update(dropTable);

        String createTable = "CREATE TABLE news (news_id int AUTO_INCREMENT PRIMARY KEY ," +
                "title varchar (500), image_url varchar (500), summary varchar (10000))";
        getJdbcTemplate().update(createTable);

        String save = "INSERT INTO news (title, image_url, summary) VALUES (?, ?, ?)";
        newsApi.getNews()
                .forEach(news -> getJdbcTemplate().update(save, news.getTitle(), news.getImageUrl(), news.getSummary()));

    }
}
