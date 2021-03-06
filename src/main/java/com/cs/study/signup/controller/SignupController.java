package com.cs.study.signup.controller;

import com.cs.study.commcode.service.CommCodeService;
import com.cs.study.commcode.vo.CommCodeDtlVO;
import com.cs.study.radioselect.service.DeptService;
import com.cs.study.radioselect.vo.DeptVO;
import com.cs.study.signup.service.SignupService;
import com.cs.study.signup.service.SignupServiceKej;
import com.cs.study.signup.vo.SignupVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SignupController {

    private final DeptService deptService;
    private final SignupService signupService;
    private final SignupServiceKej signupServiceKej;
    private final CommCodeService commCodeService;

    public SignupController(DeptService deptService, SignupService signupService, SignupServiceKej signupServiceKej, CommCodeService commCodeService) {
        this.deptService = deptService;
        this.signupService = signupService;
        this.signupServiceKej = signupServiceKej;
        this.commCodeService = commCodeService;
    }

    @GetMapping("/signup/signupKcs")
    public String signupKcs(Model model, SignupVO signupVO) {

        DeptVO deptVO = new DeptVO();
        deptVO.setDeptGrp("signup_question");
        List<DeptVO> signupQuestionList = deptService.selectDeptList(deptVO);
        model.addAttribute("signupQuestionList", signupQuestionList);

        deptVO = new DeptVO();
        deptVO.setDeptGrp("signup_phone");
        List<DeptVO> signupPhoneList = deptService.selectDeptList(deptVO);
        model.addAttribute("signupPhoneList", signupPhoneList);

        deptVO = new DeptVO();
        deptVO.setDeptGrp("signup_terms");
        List<DeptVO> signupTermsList = deptService.selectDeptList(deptVO);
        if (signupTermsList.size() > 0){
            model.addAttribute("signupTerms", signupTermsList.get(0).getDeptName());
        }

        return "signup/signupKcs";
    }
    @GetMapping("/signup/signupListKcs")
    public String signupListKcs(Model model, SignupVO signupVO) {

        List<SignupVO> selectSignupKej = signupServiceKej.selectSignupKej(signupVO);
        model.addAttribute("selectSignupKej",selectSignupKej);
        model.addAttribute("signupVO2",signupVO);

        CommCodeDtlVO commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0001");
        List<CommCodeDtlVO> phoneNumber = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        model.addAttribute("phoneNumber", phoneNumber);

        return "/signup/signupListKcs";

    }

    @PostMapping("/signup/insertSignup")
    public String insertSignup(Model model, SignupVO signupVO) {
        return "";
    }
}
