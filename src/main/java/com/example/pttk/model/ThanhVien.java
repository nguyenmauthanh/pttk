package com.example.pttk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblThanhVien")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@Data
public class ThanhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tendangnhap")
    private String tenDangNhap;

    @Column(name = "matkhau")
    private String matKhau;

    @Column(name = "sinhnhat")
    private Date sinhNhat;

    @Column(name = "gioitinh")
    private String gioiTinh;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @ManyToOne
    @JoinColumn(name = "tblDiaChiId")
    private DiaChi diaChi;

    public ThanhVien() {
    }
}
