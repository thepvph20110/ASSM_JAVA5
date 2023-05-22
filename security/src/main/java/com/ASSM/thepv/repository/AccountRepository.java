package com.ASSM.thepv.repository;

import com.ASSM.thepv.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author thepvph20110
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("SELECT a FROM Account  a WHERE a.username = ?1")
    Account findAccountByUsername(String Username);
}
