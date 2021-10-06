package com.example.springbatchdemo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Administrator
 * @Date 2021/9/25 17:58
 */
@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    //注入创建任务对象的对象
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    //任务的执行由Step决定
    //注入创建Step对象的对象
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

//    @Bean
//    public Job helloWorldJob() {
//        return jobBuilderFactory.get("helloWorldJob")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("Hello World!");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }

}
