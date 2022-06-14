package com.example.instance.order.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String orderNo;
    private String systemType;
    private String orderType;
}
