package com.alphabank.demo;

import com.alphabank.demo.entity.Storage;
import com.alphabank.demo.storage.ParseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class Parser {
    @Autowired
    private MarshallerWrapper marshallerWrapper;

    @Autowired
    private Map<String, ParseType> map;


    public Storage parse(String input) throws IOException {
        String[] values = input.split(":");
        ParseType parseType = chooseType(values[0]);
        Storage result = Objects.requireNonNull(parseType).parse(values[1], marshallerWrapper);
        return result;
    }

    private ParseType chooseType(String value) {
        ParseType parseType = map.get(value);
        log.info("Parser. chooseType " + parseType);
        return parseType;
    }
}
