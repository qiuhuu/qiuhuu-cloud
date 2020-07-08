package com.qiuhuu.test.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : qiuhuu
 * @date : 2020-07-06 09-35
 */
@Data
@Entity(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 5714231336884802925L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String userName;
    @Column
    private int age;
}
