package org.koreait.global.search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PaginationTest {

    @Test
    void test(){
        Pagination pa = new Pagination(13, 9865,10, 10);
        System.out.println(pa);
        pa.getPages().forEach(i -> System.out.println(Arrays.toString(i)));

    }
}
