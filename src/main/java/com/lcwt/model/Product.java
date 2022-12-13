package com.lcwt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/***
 * Author: - Tara Ram Goyal
 * Date & Time: - 13/12/2022 10:02:53 AM
 * Project: - Spring-Cache-Hazelcast
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PRODUCT_TBL")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    float price;
    private String category;
    private double rating;
}
