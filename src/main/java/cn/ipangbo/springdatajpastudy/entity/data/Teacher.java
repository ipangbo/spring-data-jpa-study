package cn.ipangbo.springdatajpastudy.entity.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teachers")
@Accessors(chain = true)
public class Teacher {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;
}
