package com.alphabank.demo;

import com.alphabank.demo.entity.Storage;
import com.alphabank.demo.storage.ClassPathFile;
import com.alphabank.demo.storage.ExternalFile;
import com.alphabank.demo.storage.ParseType;
import com.alphabank.demo.storage.UrlType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class Parser {

    private MarshallerWrapper marshallerWrapper;

    @Autowired
    public Parser(MarshallerWrapper marshallerWrapper) {
        this.marshallerWrapper = marshallerWrapper;
    }

    public Storage parse(String input) throws IOException {
        String[] values = input.split(":");
        ParseType parseType = chooseType(values[0]);
        Storage result = Objects.requireNonNull(parseType).parse(values[1], marshallerWrapper);
        log.info("output result is " + result);
        return result;
    }

    private ParseType chooseType(String value) {
        switch (value) {
            case ("file"):
                return new ExternalFile();
            case ("classpath"):
                return new ClassPathFile();
            case ("url"):
                return new UrlType();
        }
        return null;
    }
}
