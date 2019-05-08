package com.decipher.crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "book") @Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Sid")
    private int sid;
    @Column(name = "Name")
    private String name;
    @Column(name = "Status")
    private String status;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="student",
            joinColumns={@JoinColumn(name="Sid",referencedColumnName="Sid")},
            inverseJoinColumns={@JoinColumn(name="Sid",referencedColumnName="Sid")})
    private Student student;
}
