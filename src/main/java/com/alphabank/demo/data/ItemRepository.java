package com.alphabank.demo.data;

import com.alphabank.demo.entity.Input;
import com.alphabank.demo.entity.Item;

import java.util.List;

public interface ItemRepository {
    void save(Item storage);
    List<Integer> selectItems(Input input);
}
