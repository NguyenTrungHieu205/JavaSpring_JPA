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

import java.time.LocalDate;

@Entity
@Table(name = "Bill")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Code")
    private String code;

    @Column(name = "Purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Adrress")
    private String address;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Customer", referencedColumnName = "Id")
    private Customer customer;
}
