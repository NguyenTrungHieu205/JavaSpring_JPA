package com.example.hieuntph23322.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Color")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Code")
    @NotEmpty(message = "Khong de trong")
    private String code;

    @Column(name = "Name")
    @NotEmpty(message = "Khong de trong")
    private String name;

    @Column(name = "Date_Create")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotNull(message = "Khong de trong")
    private Date dateCreate;

    @Column(name = "Date_correct")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotNull(message = "Khong de trong")
    private Date dateCorrect;

    @Column(name = "Status")
    private Integer status;


}
