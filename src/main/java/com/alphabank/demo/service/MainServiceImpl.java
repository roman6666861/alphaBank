package com.alphabank.demo.service;

import com.alphabank.demo.data.BoxRepository;
import com.alphabank.demo.data.ItemRepository;
import com.alphabank.demo.entity.Box;
import com.alphabank.demo.entity.Input;
import com.alphabank.demo.entity.Item;
import com.alphabank.demo.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainServiceImpl implements MainService {

    private BoxRepository boxRepository;

    private ItemRepository itemRepository;
    @Autowired
    public MainServiceImpl(BoxRepository boxRepository, ItemRepository itemRepository) {
        this.boxRepository = boxRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void save(Storage storage) {
        if (Optional.ofNullable(storage.getBox()).isPresent()){
            for (Box box : storage.getBox()) {
                saveBox(box);
            }
        }
        if (Optional.ofNullable(storage.getItem()).isPresent()){
            for (Item item : storage.getItem()) {
                itemRepository.save(item);
            }
        }
    }

    @Override
    public List<Integer> selectItems(Input input) {
        return itemRepository.selectItems(input);
    }

    private void saveBox(Box currentBox){
        boxRepository.save(currentBox);
        saveItem(currentBox);
        if (Optional.ofNullable(currentBox.getBox()).isEmpty())
            return;
        for (Box box : currentBox.getBox()) {
            saveBox(box);
        }
    }
    private void saveItem(Box currentBox){
        if (Optional.ofNullable(currentBox.getItem()).isEmpty())
            return;
        for (Item item : currentBox.getItem()){
            itemRepository.save(item);
        }
    }
}
