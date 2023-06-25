package com.example.hieuntph23322.repository;

import com.example.hieuntph23322.entity.BillProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BillProductRepository extends JpaRepository<BillProduct, Integer> {
    //    @Query("SELECT PD.name, BP.number, BP.unitPrice, BP.amount, B.code " +
//            "FROM Bill B JOIN BillProduct BP ON B.id = BP.bill.id " +
//            "JOIN ProductDetail PD ON PD.id = BP.productDetail.id WHERE B.phoneNumber = ?1")
//    List<BillProduct> searchPhoneNumber(String phoneNumberSearch);
    @Query(value = "SELECT bp.* FROM bill_product bp JOIN bill b ON bp.ID_Bill = b.Id WHERE b.phone_number = ?1", nativeQuery = true)
//    @Query(value = "select Bill_Product.Id, Bill.Code, Product_Details.Name, Bill_Product.Number, Bill_Product.Unit_price, Bill_Product.Amount from Bill join Bill_Product on Bill.Id = Bill_Product.ID_Bill join Product_Details  on Product_Details.Id = Bill_Product.ID_Product_Details where Bill.Phone_Number = ?1", nativeQuery = true)
//    Page<BillProduct> searchPhoneNumber(String phoneNumberSearch, Pageable pageable);
    List<BillProduct> searchPhoneNumber(String phoneNumberSearch);
}
