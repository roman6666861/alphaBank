package com.alphabank.demo.service;

import com.alphabank.demo.entity.Input;
import com.alphabank.demo.entity.Storage;

import java.util.List;

public interface MainService {
    void save(Storage storage);
    List<Integer> selectItems(Input input);
}
