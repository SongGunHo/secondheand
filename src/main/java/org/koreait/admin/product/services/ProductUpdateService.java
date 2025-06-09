package org.koreait.admin.product.services;

import lombok.RequiredArgsConstructor;
import org.koreait.admin.product.controllers.RequestProduct;
import org.koreait.modelMapper.ModelMapper;
import org.koreait.product.entities.Product;
import org.koreait.product.repositorys.ProductRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
public class ProductUpdateService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    public Product process(RequestProduct form){
        String mode = form.getMode();
        Long seq = form.getSeq(); // 상품 등록 번호
        Product item = seq == null || seq < 1L ? new Product() : repository.findById(seq).orElseGet(Product :: new );
        if(mode != null || mode.equals("add")){ // 상품 등록
            //  상품등록 시이에만 추가 되는 정보
            item.setGid(form.getGid());
            //
            item.setName(form.getName());
            item.setCategory(form.getCategory());
            item.setStatus(form.setStatus());
            item.setComsumerProduct(form.getConsumerProduct());
            item.setSalePrice(form.getSaleProduct());
            item.setDescription(form.getDescription());
        }

    }





}
