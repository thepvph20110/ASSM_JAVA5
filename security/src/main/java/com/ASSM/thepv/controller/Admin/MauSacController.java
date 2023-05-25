package com.ASSM.thepv.controller.Admin;

import com.ASSM.thepv.entity.MauSac;
import com.ASSM.thepv.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author thepvph20110
 */

@Controller
@RequestMapping("/admin/mau-sac")
public class MauSacController {

    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("/list")
    public String listMauSac(Model model){
        List<MauSac> list = mauSacRepository.findAll();
        model.addAttribute("list", list);
        return "mausac/mau-sac";
    }

    @PostMapping("/add")
    public String addMauSac( MauSac mauSac){
        mauSacRepository.save(mauSac);
        return "redirect:/admin/mau-sac/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteMauSac(@PathVariable("id") String id){
        MauSac mauSac = mauSacRepository.findById(id).get();
        mauSacRepository.delete(mauSac);
        return "redirect:/admin/mau-sac/list";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdateMauSac(@PathVariable("id") String id,Model model){
        MauSac mauSac = mauSacRepository.findById(id).get();
        model.addAttribute("mauSac",mauSac);
        return "mausac/view-update";
    }
    @PostMapping("/update")
    public String updateMauSac(MauSac mauSac){
        mauSacRepository.save(mauSac);
        return "redirect:/admin/mau-sac/list";
    }
}
