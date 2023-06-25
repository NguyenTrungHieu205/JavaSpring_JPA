package com.example.hieuntph23322.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Cart_Detail")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Number")
    private Integer number;

    @Column(name = "Unit_price")
    private Float unitPrice;

    @Column(name = "Amount")
    private Float amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Product_Details", referencedColumnName = "Id")
    private ProductDetail productDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Cart", referencedColumnName = "Id")
    private Cart cart;
}
