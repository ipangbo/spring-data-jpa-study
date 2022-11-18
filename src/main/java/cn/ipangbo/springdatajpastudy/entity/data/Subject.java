package cn.ipangbo.springdatajpastudy.entity.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "subjects")
@Accessors(chain = true)
public class Subject {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    @Id
    private int cid;

    @Column(name = "name")
    private String name;

//    一位老师教多个课程
//    @ManyToOne
//    @JoinColumn(name = "tid")
//    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "teach_relation",
            joinColumns = @JoinColumn(name = "cid"),
            inverseJoinColumns = @JoinColumn(name = "tid"))
    List<Teacher> teachers;

    @Column(name = "time")
    private int time;
}
