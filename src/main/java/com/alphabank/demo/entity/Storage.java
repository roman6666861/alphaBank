package com.alphabank.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "Storage")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Storage {

    private List<Box> Box;

    private List<Item> Item;
}
