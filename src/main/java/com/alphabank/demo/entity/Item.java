package com.alphabank.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@Data
@Entity
@ToString
@XmlType(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @Id
    @XmlAttribute
    private long id;
    @XmlAttribute
    private String color;
}
