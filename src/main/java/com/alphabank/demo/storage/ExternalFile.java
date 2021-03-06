package com.alphabank.demo.storage;

import com.alphabank.demo.MarshallerWrapper;
import com.alphabank.demo.entity.Storage;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
@Component("file")
public class ExternalFile implements ParseType {
    @Override
    public Storage parse(String values, MarshallerWrapper marshallerWrapper) {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(values));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return marshallerWrapper.unmarshallXml(bufferedInputStream);
    }

    @Override
    public String toString() {
        return "external";
    }
}
