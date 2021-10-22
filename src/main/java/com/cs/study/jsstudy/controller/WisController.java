package com.cs.study.jsstudy.controller;

import com.cs.study.sample.service.SampleService;


import com.cs.study.sample.vo.SampleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WisController {

    private final SampleService sampleService;

    public WisController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/jsstudy/wis")
    public String syncSampleList(Model model, SampleVO sampleVO){

        return "jsstudy/wis";
    }

}
