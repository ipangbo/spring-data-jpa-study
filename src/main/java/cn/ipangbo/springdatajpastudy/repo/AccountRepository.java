package cn.ipangbo.springdatajpastudy.repo;

import cn.ipangbo.springdatajpastudy.entity.data.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsername(String username);

    Account findAccountByUsernameLike(String s);

    boolean existsAccountByUsername(String username);

    void deleteAccountByUsername(String username);

    @Query("update Account set password = ?2 where id = ?1")
    @Modifying
    int updatePasswordById(int id, String psw);

    @Query(value = "update account set password = ?2 where username = ?1", nativeQuery = true)
    @Modifying
    int updatePasswordByUsername(String username, String psw);


}
