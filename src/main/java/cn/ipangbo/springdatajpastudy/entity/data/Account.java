package cn.ipangbo.springdatajpastudy.entity.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // 使用getter访问该属性才获取
    @JoinColumn(name = "detail_id")
    private AccountDetail accountDetail;

    @OneToMany(cascade = CascadeType.ALL) // 一对多默认是Lazy
    @JoinColumn(name = "uid")
    private List<Score> scoreList ;
}
