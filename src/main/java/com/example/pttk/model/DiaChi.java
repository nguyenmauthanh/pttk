package com.example.pttk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "tblDiaChi")
@Data
@ToString(exclude="thanhViens")
public class DiaChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sonha")
    private String soNha;

    @Column(name = "toanha")
    private String toaNha;

    @Column(name = "xompho")
    private String xomPho;

    @Column(name = "phuongxa")
    private String phuongXa;

    @Column(name = "quanhuyen")
    private String quanHuyen;

    @Column(name = "tinhthanh")
    private String tinhThanh;

    @OneToMany(mappedBy = "diaChi")
    private Collection<ThanhVien> thanhViens;


    public DiaChi() {
    }
}
