package com.example.pttk.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class NhanVien extends ThanhVien{

    @Column(name = "vitri")
    private String viTri;

    public NhanVien(){}
}
