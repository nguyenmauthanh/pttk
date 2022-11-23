package com.example.pttk.repository;

import com.example.pttk.model.NhaCungCap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends CrudRepository<NhaCungCap, Integer> {
    List<NhaCungCap> findAllByTenNhaCungCapContaining(String tuKhoa);
}
