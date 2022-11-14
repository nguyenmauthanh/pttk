package com.example.pttk.model;

import lombok.Data;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Entity
@Table(name = "tblNhacungcap")
@Data
public class NhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tennhacungcap")
    private String tenNhaCungCap;

    @Column(name = "manhacungcap")
    private String maNhaCungCap;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @Column(name = "mota")
    private String moTa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tblDiaChiId", referencedColumnName = "id")
    private DiaChi diaChi;

    public NhaCungCap() {
    }
}
