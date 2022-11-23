package com.example.pttk.controller;

import com.example.pttk.dto.NhaCungCapDTO;
import com.example.pttk.model.DiaChi;
import com.example.pttk.model.NhaCungCap;
import com.example.pttk.repository.DiaChiRepository;
import com.example.pttk.repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class NhaCungCapController {

    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    @Autowired
    private DiaChiRepository diaChiRepository;

    @GetMapping("/quanLyThongTinNCC")
    public String getQuanLyThongTinNCC(){
        return "QuanLyThongTinNCCView";
    }

    @GetMapping("/quanLyThongTinNCC/them")
    public String getThemNCC(){
        return "ThemNCCView";
    }

    @PostMapping("/quanLyThongTinNCC/them")
    public String postThemNCC(@ModelAttribute NhaCungCapDTO nhaCungCap){
        if(nhaCungCap != null){
            NhaCungCap ncc = new NhaCungCap();
            ncc.setTenNhaCungCap(nhaCungCap.getTenNhaCungCap());
            ncc.setMaNhaCungCap(nhaCungCap.getMaNhaCungCap());
            ncc.setSoDienThoai(nhaCungCap.getSoDienThoai());
            ncc.setDiaChi(nhaCungCap.getDiaChi());
            ncc.setMoTa(nhaCungCap.getMoTa());
            nhaCungCapRepository.save(ncc);
        }
        return "redirect:/quanLyThongTinNCC";
    }

    @GetMapping("/quanLyThongTinNCC/sua/timKiem")
    public String getTimKiemDeSua(@Param("tuKhoa") String tuKhoa, Model model){
        if(tuKhoa == null) return "ThongTinNCCView" ;
        List<NhaCungCap> dsNhaCungCap = nhaCungCapRepository.findAllByTenNhaCungCapContaining(tuKhoa);
        model.addAttribute("dsNhaCungCap", dsNhaCungCap);
        return "ThongTinNCCView";
    }

    @GetMapping("/quanLyThongTinNCC/sua/{id}")
    public String getSuaNCC(@PathVariable String id, Model model){
        Optional<NhaCungCap> nhaCungCap = nhaCungCapRepository.findById(Integer.parseInt(id));
        if(nhaCungCap.isEmpty()) return "NotFound";
        model.addAttribute("nhaCungCap", nhaCungCap.get());
        return "SuaNccView";
    }

    @PostMapping("/quanLyThongTinNCC/sua/{id}")
    public String postSuaNCC(@PathVariable String id,@ModelAttribute NhaCungCapDTO nhaCungCapDTO){
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setId(Integer.parseInt(id));
        nhaCungCap.setTenNhaCungCap(nhaCungCapDTO.getTenNhaCungCap());
        nhaCungCap.setMaNhaCungCap(nhaCungCapDTO.getMaNhaCungCap());
        nhaCungCap.setSoDienThoai(nhaCungCapDTO.getSoDienThoai());
        nhaCungCap.setDiaChi(nhaCungCapDTO.getDiaChi());
        nhaCungCap.setMoTa(nhaCungCapDTO.getMoTa());
        nhaCungCapRepository.save(nhaCungCap);
        return "redirect:/quanLyThongTinNCC/sua/timKiem";
    }

    @GetMapping("/quanLyThongTinNCC/xoa/{id}")
    public String getXoaNCC(@PathVariable String id){
        Optional<NhaCungCap> nhaCungCap = nhaCungCapRepository.findById(Integer.parseInt(id));
        if(nhaCungCap.isEmpty()) return "NotFound";
        nhaCungCapRepository.deleteById(Integer.parseInt(id));
        return "redirect:/quanLyThongTinNCC/sua/timKiem";
    }

}
