package com.example.pttk.model;

import lombok.Data;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.Collection;
import java.util.Set;

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

    private String diaChi;

    @OneToMany(mappedBy = "nhaCungCap")
    private Collection<HoaDonNhapHang> hoaDonNhapHangs;

    public NhaCungCap() {
    }
}
