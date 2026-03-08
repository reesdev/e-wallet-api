package com.latihan.ewallet.controller;

import com.latihan.ewallet.dto.WalletRequest;
import com.latihan.ewallet.dto.WalletResponse;
import com.latihan.ewallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService service;

    @PostMapping("/create")
    public WalletResponse createWallet(@RequestBody WalletRequest request){
        return service.createWallet(request);
    }
    @GetMapping("/{id}")
    public WalletResponse getWallet(@PathVariable Long id){
        return service.getWallet(id);
    }
    @PostMapping("/topup/{id}")
    public WalletResponse topUp(
            @PathVariable Long id,
            @RequestParam Integer amount) {

        return service.topUp(id, amount);
    }
    @PostMapping("/pay/{id}")
    public WalletResponse pay(
            @PathVariable Long id,
            @RequestParam Integer amount) {

        return service.pay(id, amount);
    }
}
