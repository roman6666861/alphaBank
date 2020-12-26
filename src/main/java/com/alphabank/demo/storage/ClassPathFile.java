package com.alphabank.demo.storage;

import com.alphabank.demo.MarshallerWrapper;
import com.alphabank.demo.entity.Storage;

public class ClassPathFile implements ParseType {
    @Override
    public Storage parse(String input, MarshallerWrapper marshallerWrapper) {
        return marshallerWrapper.unmarshallXml(this.getClass().getClassLoader().getResourceAsStream(input));
    }
}
