package org.koreait.admin.global.search;

import lombok.Data;

import java.util.List;

@Data
public class ListDate<T>{

    private List<T> item;
    private Pageination pageination;







}
