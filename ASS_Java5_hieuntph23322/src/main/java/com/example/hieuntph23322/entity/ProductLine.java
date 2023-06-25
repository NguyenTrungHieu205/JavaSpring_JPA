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

import java.util.Date;

@Entity
@Table(name = "Product_Line")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Code")
    @NotEmpty(message = "Khong de trong")
    private String code;

    @Column(name = "Name")
    @NotEmpty(message = "Khong de trong")
    private String name;

    @Column(name = "Import_price")
    @NotNull(message = "Khong de trong")
    private Float importPrice;

    @Column(name = "Price")
    @NotNull(message = "Khong de trong")
    private Float price;

    @Column(name = "Date_Create")
    private Date dateCreate;

    @Column(name = "Date_correct")
    private Date dateCorrect;

    @Column(name = "Status")
    @NotNull(message = "Khong de trong")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "ID_Manufacturer")
    private Manufacturer manufacturer;


}
