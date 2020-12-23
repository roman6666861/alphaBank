package com.alphabank.demo.data;

import com.alphabank.demo.entity.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoxRepositoryImpl implements BoxRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public BoxRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public void save(Box box) {
        jdbc.update("insert into box (id) values (?)",
                box.getId());
    }
}
