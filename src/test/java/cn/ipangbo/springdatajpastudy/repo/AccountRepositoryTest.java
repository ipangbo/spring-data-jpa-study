package cn.ipangbo.springdatajpastudy.repo;

import cn.ipangbo.springdatajpastudy.entity.data.Account;
import cn.ipangbo.springdatajpastudy.entity.data.AccountDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 懒加载要在事务环境中
class AccountRepositoryTest {

    @Autowired
    AccountRepository repository;

    @Test
    void canFindById() {
        Optional<Account> firstUser = repository.findById(1);
        firstUser.ifPresent(account -> {
            System.out.println(account.getUsername());
            System.out.println(account.getAccountDetail());
        });

    }

    @Test
    void canAddAccount() {
        Account account = repository.save(
                new Account()
                        .setUsername("ipangbotest")
                        .setPassword("6")
                        .setAccountDetail(
                                new AccountDetail()
                                        .setAddress("东北林业大学")
                                        .setEmail("pangbo@ipangbo.cn")
                                        .setRealName("庞乐佳")
                                        .setPhone("18715581009")
                        ));
        System.out.println(account.getId());
    }

    @Test
    void canDeleteAccount() {
        repository.deleteAccountByUsername("ipangbotest");
    }

    @Test
    void canPagingAccount() {
        Page<Account> accountPage = repository.findAll(PageRequest.of(1, 3));
        accountPage.forEach(System.out::println);
    }

    @Test
    void canFindByUsername() {
        System.out.println(repository.findAccountByUsername("ipangbo"));
        System.out.println(repository.count());
    }

    @Test
    void canFindByLikeUsername() {
        System.out.println(repository.findAccountByUsernameLike("%i%"));
    }

    @Test
    void ifExistsByUsername() {
        System.out.println(repository.existsAccountByUsername("ipangbo"));
    }

    @Test
    void canFindScore() {
        repository.findAccountByUsername("ipangbo").getScoreList().forEach(System.out::println);
    }
}