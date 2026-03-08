package com.latihan.ewallet.service;

import com.latihan.ewallet.dto.WalletRequest;
import com.latihan.ewallet.dto.WalletResponse;
import com.latihan.ewallet.entity.Wallet;
import com.latihan.ewallet.exception.WalletNotFoundException;
import com.latihan.ewallet.repository.WalletRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WalletService {

    private final WalletRepository repo;

    public WalletService(WalletRepository repo) {
        this.repo = repo;
    }

    private Wallet findWallet(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found"));
    }

    private WalletResponse mapToResponse(Wallet wallet){

        WalletResponse response = new WalletResponse();
        response.setId(wallet.getId());
        response.setOwner(wallet.getOwner());
        response.setBalance(wallet.getBalance());
//        BeanUtils.copyProperties(wallet, response);

        return response;
    }

    public WalletResponse createWallet(WalletRequest request){

        Wallet wallet = new Wallet();
        wallet.setOwner(request.getOwner());
        wallet.setBalance(0);

        repo.save(wallet);

        return mapToResponse(wallet);
    }

    @Transactional(readOnly = true)
    public WalletResponse getWallet(Long id){

        Wallet wallet = findWallet(id);
        return mapToResponse(wallet);
    }

    public WalletResponse topUp(Long id, Integer amount){

        Wallet wallet = findWallet(id);

        wallet.setBalance(wallet.getBalance() + amount);

        return mapToResponse(wallet);
    }

    public WalletResponse pay(Long id, Integer amount){

        Wallet wallet = findWallet(id);

        wallet.setBalance(wallet.getBalance() - amount);

        return mapToResponse(wallet);
    }
    public WalletResponse transfer(Long fromId, Long toId, Integer amount) {

        if (fromId.equals(toId)) {
            throw new RuntimeException("Cannot transfer to the same wallet");
        }

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        Wallet fromWallet = findWallet(fromId);
        Wallet toWallet = findWallet(toId);

        if (fromWallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        fromWallet.setBalance(fromWallet.getBalance() - amount);
        toWallet.setBalance(toWallet.getBalance() + amount);

        return mapToResponse(fromWallet);
    }

}