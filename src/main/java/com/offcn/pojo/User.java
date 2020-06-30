package com.offcn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

     @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "tb_user") /*利用实体类自动创建表一一对应*/
    public class User {
        @Id
        @GeneratedValue
        private Long id;
        @Column(name = "name",nullable = false,length = 100)
        private String name;
        @Column(name = "age",nullable = true,length = 4)
        private Integer age;
    }

