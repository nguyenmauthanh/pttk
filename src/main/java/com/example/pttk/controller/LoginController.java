package com.example.pttk.controller;

import com.example.pttk.dto.ThanhVienDTO;
import com.example.pttk.model.ThanhVien;
import com.example.pttk.repository.ThanhVienDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private ThanhVienDAO thanhVienDAO;

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/")
    public String postLogin(@ModelAttribute ThanhVienDTO thanhVienDTO){
        ThanhVien t = thanhVienDAO.findByTenDangNhap(thanhVienDTO.getTenDangNhap());
        if(t == null) return "404 user not found";
        if(!thanhVienDTO.getMatKhau().equals(t.getMatKhau())){
            return "Sai tên đăng nhập";
        }
        return "nhanvienkhoview";
    }
}
