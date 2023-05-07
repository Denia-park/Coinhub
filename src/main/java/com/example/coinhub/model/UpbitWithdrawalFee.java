package com.example.coinhub.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

@Getter
@Setter
public class UpbitWithdrawalFee {
    private static ObjectMapper mapper = new ObjectMapper();
    private boolean success;
    private String data;

    public List<UpbitEachWithdrawalFee> getData() throws IOException {
        return mapper.readValue(data, new TypeReference<>() {
        });
    }

}
