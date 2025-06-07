package org.koreait.globle.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    @CreatedDate
    @Column("createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("modifiedAt")
    private LocalDateTime modifiedAt;

    @Column("deletedAt")
    private LocalDateTime deletedAt;




}
