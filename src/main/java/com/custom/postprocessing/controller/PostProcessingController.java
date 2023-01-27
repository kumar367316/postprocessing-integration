package com.custom.postprocessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.custom.postprocessing.entity.PostProcessingJsonEntity;
import com.custom.postprocessing.scheduler.PostProcessingScheduler;

/**
 * @author kumar.charanswain
 *
 */

@RestController
public class PostProcessingController {

    @Autowired
    private PostProcessingScheduler postProcessingScheduler;

    @GetMapping(path = "/postprocess")
    public PostProcessingJsonEntity manualPostProcessBatch() {

    	PostProcessingJsonEntity postProcessingJsonEntity = postProcessingScheduler.smartCommPostProcessing();
    	
    	return postProcessingJsonEntity;
    }
    
    @GetMapping(path = "/test")
    public String apiTest() {

    	return "api testing in azure app services";
    }
    
}
