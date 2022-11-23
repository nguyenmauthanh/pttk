package com.example.pttk.repository;

import com.example.pttk.model.NhanVien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends CrudRepository<NhanVien, Integer> {
}
