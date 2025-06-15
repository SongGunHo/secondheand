package org.koreait.global.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koreait.trend.entities.Trend;
import org.koreait.trend.entities.TrendUrl;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListDate<T>{

    private List<TrendUrl> items;
    private Pagination pagination;

}
