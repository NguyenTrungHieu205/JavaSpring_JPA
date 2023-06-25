package com.example.hieuntph23322.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Product_Details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Code")
    @NotEmpty(message = "Khong de trong")
    private String code;

    @Column(name = "Name")
    @NotEmpty(message = "Khong de trong")
    private String name;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Number")
    @NotNull(message = "Khong de trong")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "ID_Category")
    private Category category;

    @Column(name = "images")
    private String images;


}
