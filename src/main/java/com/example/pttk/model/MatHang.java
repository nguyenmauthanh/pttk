package com.example.pttk.model;

import lombok.Cleanup;

import javax.persistence.*;

@Entity
@Table(name = "tblMathang")
public class MatHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tenmathang")
    private String tenMatHang;

    @Column(name = "mota")
    private String moTal;

    @Column(name = "donvi")
    private int donVi;

    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "giatien")
    private int giaTien;

    public MatHang(){

    }
}
