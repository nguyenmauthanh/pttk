package com.example.pttk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tblHoadonnhaphang")
@Data
public class HoaDonNhapHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mahoadon")
    private String maHoaDon;

    @ManyToOne
    @JoinColumn(name = "tblNhacungcapId")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "tblNhanvienId")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "hoaDonNhapHang")
    private Set<HoaDonMatHang> hoaDonMatHangs;
}
