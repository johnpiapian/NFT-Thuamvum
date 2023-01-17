package com.appzomi.NFTThuamvumBackend.Repo;

import com.appzomi.NFTThuamvumBackend.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByUsernameAndPassword(String username, String password);
}
