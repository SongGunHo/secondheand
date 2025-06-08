package org.koreait.trend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("Trend")
public class Trend {

    @Id
    private Long seq;
    private String category;


    @Column("wordCloud")
    private String wordCloud;
    private String keywords;









}
