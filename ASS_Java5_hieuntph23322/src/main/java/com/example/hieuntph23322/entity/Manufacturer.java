package com.example.hieuntph23322.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "Manufacturer")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Code")
    @NotEmpty(message = "Khong de trong")
    private String code;

    @Column(name = "Name_Manufacturer")
    @NotEmpty(message = "Khong de trong")
    private String nameManufacturer;

    @Column(name = "Date_Create")
    private Date dateCreate;

    @Column(name = "Date_Correct")
    private Date dateCorrect;

    @Column(name = "Status")
    private Integer status;


}
