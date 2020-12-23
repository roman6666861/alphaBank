package com.alphabank.demo;

import com.alphabank.demo.entity.TypeOfLink;
import com.alphabank.demo.entity.Storage;
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

    private GenericApplicationContext context;

    @Autowired
    public Parser(MarshallerWrapper marshallerWrapper, GenericApplicationContext context) {
        this.marshallerWrapper = marshallerWrapper;
        this.context = context;
    }
    public Storage parseToStorage() throws IOException {
        Storage output = null;
        TypeOfLink typeoflink = (TypeOfLink) context.getBean("Input");
        String[] values = typeoflink.getInput().split(":");
        if (values[0].equals("file")) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream
                    ("D:\\java projects\\alphaBank\\src\\main\\resources\\"+values[1]));
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
