package com.alphabank.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

@Component
public class MarshallerWrapper {

    private Jaxb2Marshaller marshaller;

    @Autowired
    public MarshallerWrapper(Jaxb2Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public <T> T unmarshallXml(final InputStream xml){
        return (T) marshaller.unmarshal(new StreamSource(xml));
    }
}
