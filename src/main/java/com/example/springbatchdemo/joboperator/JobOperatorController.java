package com.example.springbatchdemo.joboperator;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;

import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Administrator
 * @Date 2021/10/6 12:04
 */
@RestController
@RequestMapping("job2")
public class JobOperatorController {

    @Autowired
    private JobOperator jobOperator;

    @GetMapping("/{msg2}")
    public String runJob1(@PathVariable String msg2) throws JobParametersInvalidException, JobInstanceAlreadyExistsException, NoSuchJobException {

        //启动任务，同时传参数
        jobOperator.start("jobOperatorDemoJob", "msg2=" + msg2);
        return "Job success";
    }
}
