package com.alphabank.demo.storage;

import com.alphabank.demo.MarshallerWrapper;
import com.alphabank.demo.entity.Storage;

public interface ParseType {
    Storage parse(String input, MarshallerWrapper marshallerWrapper);
}
