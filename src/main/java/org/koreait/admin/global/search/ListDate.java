package org.koreait.admin.global.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListDate<T>{

    private List<T> items;
    private Pagination pagination;

}
