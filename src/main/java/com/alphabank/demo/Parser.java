package com.alphabank.demo;

import com.alphabank.demo.entity.Storage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
@Slf4j
@Component
public class Parser {

    private MarshallerWrapper marshallerWrapper;

    @Setter
    private String input;

    @Autowired
    public Parser(MarshallerWrapper marshallerWrapper) {
        this.marshallerWrapper = marshallerWrapper;
    }
    public Storage parseToStorage() throws IOException {
        Storage output = null;
        String[] values = input.split(":");
        if (values[0].equals("file")) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(values[1]));
            output = marshallerWrapper.unmarshallXml(bufferedInputStream);
        }
        else if (values[0].equals("classpath")){
            output = marshallerWrapper.unmarshallXml(this.getClass().getClassLoader().getResourceAsStream("input.xml"));
        }
        else if (values[0].equals("url")) {
            output = marshallerWrapper.unmarshallXml(new BufferedInputStream(new URL(values[1]).openStream()));
        }
        log.info("output is " + output);
        return output;
    }
}
