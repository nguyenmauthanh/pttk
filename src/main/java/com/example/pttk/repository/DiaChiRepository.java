package com.example.pttk.repository;

import com.example.pttk.model.DiaChi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaChiRepository extends CrudRepository<DiaChi, Integer> {
    DiaChi findByTinhThanh(String diaChi);
}
