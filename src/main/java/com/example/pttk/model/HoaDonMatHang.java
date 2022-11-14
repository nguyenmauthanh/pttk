package com.example.pttk.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tblHoadonmathang")
@Data
public class HoaDonMatHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "giatien")
    private float giaTien;

    @Column(name = "soluong")
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "tblHoadongnhaphangId")
    private HoaDonNhapHang hoaDonNhapHang;

    @ManyToOne
    @JoinColumn(name = "tblMathangId")
    private MatHang matHang;

}
