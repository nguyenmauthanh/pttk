package com.example.pttk.model;


import javax.persistence.*;

@Entity
public class NhanVien extends ThanhVien{

    @Column(name = "vitri")
    private String viTri;

    public NhanVien(){}
}
