package com.latihan.ewallet.controller;

import com.latihan.ewallet.dto.WalletRequest;
import com.latihan.ewallet.dto.WalletResponse;
import com.latihan.ewallet.service.WalletService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping
    public WalletResponse createWallet(@RequestBody WalletRequest request){
        return service.createWallet(request);
    }

    @GetMapping("/{id}")
    public WalletResponse getWallet(@PathVariable Long id){
        return service.getWallet(id);
    }

    @PostMapping("/{id}/topup")
    public WalletResponse topUp(
            @PathVariable Long id,
            @RequestParam Integer amount){

        return service.topUp(id, amount);
    }

    @PostMapping("/{id}/pay")
    public WalletResponse pay(
            @PathVariable Long id,
            @RequestParam Integer amount){

        return service.pay(id, amount);
    }

    @PostMapping("/transfer")
    public WalletResponse transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam Integer amount){

        return service.transfer(fromId, toId, amount);
    }

}