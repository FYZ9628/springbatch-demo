//package com.example.springbatchdemo.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//
///**
// * 多任务并行处理（异步执行）
// *
// * @Author Administrator
// * @Date 2021/9/25 21:28
// */
//@Configuration
//@EnableBatchProcessing
//public class SplitDemo {
//
//    //注入创建任务对象的对象
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    //任务的执行由Step决定
//    //注入创建Step对象的对象
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Step splitDemoStep1() {
//        return stepBuilderFactory.get("splitDemoStep1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("splitDemoStep1");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step splitDemoStep2() {
//        return stepBuilderFactory.get("splitDemoStep2")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("splitDemoStep2");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step splitDemoStep3() {
//        return stepBuilderFactory.get("splitDemoStep3")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("splitDemoStep3");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Flow splitDemoFlow1() {
//        return new FlowBuilder<Flow>("splitDemoFlow1")
//                .start(splitDemoStep1())
//                .build();
//    }
//
//    @Bean
//    public Flow splitDemoFlow2() {
//        return new FlowBuilder<Flow>("splitDemoFlow2")
//                .start(splitDemoStep2())
//                .next(splitDemoStep3())
//                .build();
//    }
//
//    //创建任务
//    @Bean
//    public Job splitDemoJob() {
//        return jobBuilderFactory.get("splitDemoJob")
//                .start(splitDemoFlow1())
//                .split(new SimpleAsyncTaskExecutor()).add(splitDemoFlow2())
//                .end()
//                .build();
//    }
//}