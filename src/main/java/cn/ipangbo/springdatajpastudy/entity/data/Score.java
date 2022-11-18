package cn.ipangbo.springdatajpastudy.entity.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account_score")
@Accessors(chain = true)
public class Score {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "cid")
    private Subject subject;

    @Column(name = "score")
    private double score;

    @Column(name = "uid")
    private int uid;

}
