package cn.ipangbo.springdatajpastudy.repo;

import cn.ipangbo.springdatajpastudy.entity.data.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsername(String username);

    Account findAccountByUsernameLike(String s);

    boolean existsAccountByUsername(String username);

    void deleteAccountByUsername(String username);


}
