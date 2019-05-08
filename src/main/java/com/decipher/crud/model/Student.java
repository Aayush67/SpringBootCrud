package com.decipher.crud.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student") @Data
public class Student {
    @Id
    @Column(name = "Sid")
    private int sid;
    @Column(name = "Username")
    private String userName;
}
