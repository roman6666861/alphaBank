package com.alphabank.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;

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
