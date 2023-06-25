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
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Code")
    @NotEmpty(message = "Khong de trong")
    private String code;

    @Column(name = "Name")
    @NotEmpty(message = "Khong de trong")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_Color")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "ID_Capacity")
    private Capacity capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Product_Line", referencedColumnName = "id")
    private ProductLine productLine;

    @Column(name = "Status")
    private Integer status;


}
