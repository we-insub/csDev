package com.cs.study.signup.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cs.study.sample.vo.SampleVO;
import com.cs.study.sample.vo.VisitVO;
import com.cs.study.signup.service.SignupServiceWis;
import com.cs.study.signup.vo.SignupVOWis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cs.study.commcode.service.CommCodeService;
import com.cs.study.commcode.vo.CommCodeDtlVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SignupControllerWis {

    private final CommCodeService commCodeService;
    private final SignupServiceWis signupServiceWis;

    public SignupControllerWis(CommCodeService commCodeService, SignupServiceWis signupServiceWis) {
        this.commCodeService = commCodeService;
        this.signupServiceWis = signupServiceWis;
    }

    @GetMapping("/signup/signupWis")
    public String signupWis(Model model, SignupVOWis signupVOwis) {

        CommCodeDtlVO commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0001");
        List<CommCodeDtlVO> signupPhone = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        model.addAttribute("signupPhone", signupPhone);

        commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0002");
        List<CommCodeDtlVO> signupPwAnswer = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        model.addAttribute("signupPwAnswer", signupPwAnswer);

        commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0003");
        ;
        List<CommCodeDtlVO> signupGender = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        model.addAttribute("signupGender", signupGender);

        commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0004");
        ;
        List<CommCodeDtlVO> signupTermsList = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        if (signupTermsList.size() > 0) {
            model.addAttribute("signupTermsList", signupTermsList.get(0).getDtlNm());
        }

        return "signup/signupWis";
    }

    @PostMapping("/signup/insertSignupWis")
    public String insertSignupWis(Model model, SignupVOWis signupVOWis) {
        int insertYN = signupServiceWis.insertSignupWis(signupVOWis);
        if (insertYN <= 1) {
            model.addAttribute("signupVOWis", signupVOWis);

            CommCodeDtlVO commCodeDtlVO = new CommCodeDtlVO();
            commCodeDtlVO.setMstCd("M0001");
            List<CommCodeDtlVO> signupPhone = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
            model.addAttribute("signupPhone", signupPhone);

            commCodeDtlVO = new CommCodeDtlVO();
            commCodeDtlVO.setMstCd("M0002");
            List<CommCodeDtlVO> signupPwAnswer = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
            model.addAttribute("signupPwAnswer", signupPwAnswer);

            commCodeDtlVO = new CommCodeDtlVO();
            commCodeDtlVO.setMstCd("M0003");
            ;
            List<CommCodeDtlVO> signupGender = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
            model.addAttribute("signupGender", signupGender);

            commCodeDtlVO = new CommCodeDtlVO();
            commCodeDtlVO.setMstCd("M0004");
            ;
            List<CommCodeDtlVO> signupTermsList = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
            if (signupTermsList.size() > 0) {
                model.addAttribute("signupTermsList", signupTermsList.get(0).getDtlNm());
            }
            return "/signup/signupWis";
        } else {

            return "redirect:/signup/signupListWis";
        }
    }

    @GetMapping("/signup/signupListWis")
    public String signupListwis(Model model, SignupVOWis signupVOWis) {

        List<SignupVOWis> signupListwis = signupServiceWis.signupListwis(signupVOWis);
//        List<SignupVOWis> signupListwis2 = signupServiceWis.signupListwis2(signupVOWis);
        model.addAttribute("signupListwis", signupListwis);
//        model.addAttribute("signupListwis2", signupListwis2);
        model.addAttribute("signupVOWis", signupVOWis);

        CommCodeDtlVO commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0002");
        List<CommCodeDtlVO> signupPwAnswer = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        model.addAttribute("signupPwAnswer", signupPwAnswer);

        commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0003");
        ;
        List<CommCodeDtlVO> signupGender = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        model.addAttribute("signupGender", signupGender);

        commCodeDtlVO = new CommCodeDtlVO();
        commCodeDtlVO.setMstCd("M0001");
        List<CommCodeDtlVO> signupPhone = commCodeService.selectCommCodeDtlList(commCodeDtlVO);
        model.addAttribute("signupPhone", signupPhone);


        return "signup/signupListWis";
    }

    @PostMapping("/signup/listUpdate")
    public String listUpdate(Model model, SignupVOWis signupVOWis, @RequestParam(value = "action", required = true) String action ) {

        System.out.println("*********************************************************************************************"+action);
        if ("update".equals(action)) {
            List<SignupVOWis> updateList = signupVOWis.getListSignupVOWis();

            System.out.println("for 문 돌기전에 확인");
            for (int i = 0; i < updateList.size(); i++) {

                SignupVOWis vo = updateList.get(i);
//                System.out.println("*********************");
//                System.out.println(vo);
//                System.out.println("*********************");
                signupServiceWis.ListUpdate(updateList.get(i));

            }
        } else if ("delete".equals(action)) {
            List<SignupVOWis> ListDelete = signupVOWis.getListSignupVOWis();

            System.out.println("for 문 돌기전에 확인");
            for (int i = 0; i < ListDelete.size(); i++) {

                SignupVOWis vo = ListDelete.get(i);
                System.out.println("*********************");
                System.out.println(vo);
                System.out.println("*********************");
                System.out.println("Btncheck 버튼체크 : "+signupVOWis.getBtncheck());

                if(signupVOWis.getBtncheck() == "Y"){
                    System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
                    //int deleteCnt = signupServiceWis.ListDelete(signupVOWis);
                }


                //int deleteCnt = signupServiceWis.ListDelete(signupVOWis);

                //signupServiceWis.ListDelete(signupVOWis);
                signupServiceWis.ListUpdate(ListDelete.get(i));

            }
            System.out.println("============================");
        }
            return "redirect:/signup/signupListWis";

    }
}
//
//    public String syncSampleFormSave(Model model, SampleVO sampleVO, @RequestParam(value="action", required=true) String action){
//        if ( "save".equals(action) ){
//            int saveCnt = sampleService.saveSample(sampleVO);
//        }else if ( "delete".equals(action) ){
//            int deleteCnt = sampleService.deleteSample(sampleVO);
//        }
//        return "redirect:/syncSampleListWis";