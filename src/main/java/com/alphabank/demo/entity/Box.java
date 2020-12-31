package com.alphabank.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@Entity
@ToString
@XmlType(name = "Box")
@XmlAccessorType(XmlAccessType.FIELD)
public class Box {
    @Id
    @GeneratedValue
    @XmlAttribute
    private long id;

    @OneToMany(mappedBy = "parent")
    private List<Box> Box;

    @ManyToOne
    @JoinColumn(name="ID", insertable = false, updatable = false)
    private Box parent;

    @OneToMany
    private List<Item> Item;
}
