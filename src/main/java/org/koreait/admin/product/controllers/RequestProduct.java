package org.koreait.admin.product.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import org.koreait.member.services.LoginSuccessHandler;
import org.koreait.product.constants.ProductStatus;

@Data
public class RequestProduct {
    private String mode; // add  추가 edit - 수정
    private Long seq;
    private String gid;

    @NotBlank
    private String name;
    private String category;
    @NonNull
    private ProductStatus status;
    private int consumerProduct;
    private int saleProduct;
    private String description;




}
