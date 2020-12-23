package com.alphabank.demo;

import com.alphabank.demo.entity.Box;
import com.alphabank.demo.entity.Item;
import com.alphabank.demo.entity.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;

@Configuration
public class ConfigClass {
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Box.class, Item.class, Storage.class);
        return marshaller;
    }
}
