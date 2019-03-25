package edu.ap.spring.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {

    public List<Wallet> findByName(String walletName);

}