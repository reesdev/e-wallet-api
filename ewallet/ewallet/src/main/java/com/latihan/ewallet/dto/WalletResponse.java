package com.latihan.ewallet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletResponse {
    private Long id;
    private String owner;
    private Integer balance;
}
