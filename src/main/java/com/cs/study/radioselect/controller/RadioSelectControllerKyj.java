package com.cs.study.radioselect.controller;

import com.cs.study.radioselect.service.DeptService;
import com.cs.study.radioselect.service.RadioSelectService;
import com.cs.study.radioselect.vo.DeptVO;
import com.cs.study.radioselect.vo.RadioSelectVO;
import com.cs.study.sample.vo.SampleVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RadioSelectControllerKyj {

    private final DeptService deptService;
    private final RadioSelectService radioSelectService;

    public RadioSelectControllerKyj(DeptService deptService, RadioSelectService radioSelectService) {
        this.deptService = deptService;
        this.radioSelectService = radioSelectService;
    }
    
    @GetMapping("/radioselect/kyjList")
    public String kcsList(Model model, RadioSelectVO radioSelectVO){
        List<RadioSelectVO> selectRadioSelectList = radioSelectService.selectRadioSelectList(radioSelectVO);
        model.addAttribute("selectRadioSelectList", selectRadioSelectList);
        model.addAttribute("radioSelectVO", radioSelectVO);
        return "radioselect/kyjList";
    }
   
    @GetMapping("/radioselect/kyjForm")
    public String kcsForm(Model model, RadioSelectVO radioSelectVO, DeptVO deptVO){
        DeptVO radio01VO = new DeptVO();
        radio01VO.setDeptGrp("radio01");
        List<DeptVO> radio01List = deptService.selectDeptList( radio01VO );
        model.addAttribute("radio01List", radio01List);
        
        DeptVO radio02VO = new DeptVO();
        radio02VO.setDeptGrp("radio02");
        List<DeptVO> radio02List = deptService.selectDeptList( radio02VO );
        model.addAttribute("radio02List", radio02List);
        
        DeptVO select01VO = new DeptVO();
        select01VO.setDeptGrp("select01");
        List<DeptVO> select01List = deptService.selectDeptList( select01VO );
        model.addAttribute("select01List", select01List);

        DeptVO select02VO = new DeptVO();
        select02VO.setDeptGrp("select02");
        List<DeptVO> select02List = deptService.selectDeptList( select02VO );
        model.addAttribute("select02List", select02List);

        
        RadioSelectVO selectRadioSelectVO = radioSelectService.selectRadioSelectOne(radioSelectVO);
        model.addAttribute("selectRadioSelectVO", selectRadioSelectVO);
        
        return "radioselect/kyjForm";
    }
    
    @PostMapping("/updateRadioSelectkyj")
    public String updateRadioSelectKcs(Model model, RadioSelectVO radioSelectVO){
        radioSelectService.updateRadioSelect(radioSelectVO);
        return "redirect:/radioselect/kyjList";
    } 
}
