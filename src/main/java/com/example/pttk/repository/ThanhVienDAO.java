package com.example.pttk.repository;

import com.example.pttk.model.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThanhVienDAO extends JpaRepository<ThanhVien, Integer> {
    ThanhVien findByTenDangNhap(String tenDangNhap);
}
