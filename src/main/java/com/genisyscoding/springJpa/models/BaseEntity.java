package com.genisyscoding.springJpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@MappedSuperclass

public class BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @CreatedDate
    private LocalDateTime created_at;
    @LastModifiedBy
    private LocalDateTime last_modify;
    @CreatedBy
    private String created_by;
    @LastModifiedBy
    private String modify_by;
}
