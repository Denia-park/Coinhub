package com.example.coinhub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BithumbAssetEachStatus {
    private int withdrawal_status;
    private int deposit_status;

}
