package com.alphabank.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
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

    @OneToMany(mappedBy = "parent",
            fetch=FetchType.EAGER)
    private List<Box> Box;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID", insertable = false, updatable = false)
    private Box parent;

    @OneToMany
    private List<Item> Item;
}
