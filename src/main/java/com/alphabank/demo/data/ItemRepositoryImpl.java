package com.alphabank.demo.data;

import com.alphabank.demo.entity.Input;
import com.alphabank.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private JdbcTemplate jdbc;

    private final static String selectSql = "select item.id from box, item where box.id = ?  and item.color = ?";

    @Autowired
    public ItemRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public void save(Item item) {
        jdbc.update("insert into item (id, color) values (?,?)",
                item.getId(), item.getColor());
    }

    @Override
    public List<Integer> selectItems(Input input) {
        return jdbc.query(selectSql, (resultSet, i) -> resultSet.getInt(1), input.getBox(), input.getColor());
    }
}
