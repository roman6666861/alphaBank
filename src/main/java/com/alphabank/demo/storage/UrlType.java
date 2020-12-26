package com.alphabank.demo.storage;

import com.alphabank.demo.MarshallerWrapper;
import com.alphabank.demo.entity.Storage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

public class UrlType implements ParseType {
    @Override
    public Storage parse(String input, MarshallerWrapper marshallerWrapper) {
        try {
            return marshallerWrapper.unmarshallXml(new BufferedInputStream(new URL(input).openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
