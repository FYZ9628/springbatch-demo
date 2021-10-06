package com.example.springbatchdemo.joblauncher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外暴露的接口
 *
 * @Author Administrator
 * @Date 2021/10/6 11:31
 */
@RestController
public class JobLauncherController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job jobLauncherDemoJob;


    //前端地址  http://localhost:8080/
    @RequestMapping("/job/{msg}")
    public String jobRun1(@PathVariable String msg) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        //把接收到的参数值传给任务
        JobParameters parameters = new JobParametersBuilder()
                .addString("msg",msg)
                .toJobParameters();

        //启动任务，并把参数传给任务
        jobLauncher.run(jobLauncherDemoJob,parameters);
        return "job success";
    }
}
