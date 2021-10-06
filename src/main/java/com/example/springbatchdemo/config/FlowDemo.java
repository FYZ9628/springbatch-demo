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
//
///**
// * flow可以包含多个step，flow的作用像是分组，最终还是得在job中执行才可以运行step
// *
// * @Author Administrator
// * @Date 2021/9/25 21:15
// */
//@Configuration
//@EnableBatchProcessing
//public class FlowDemo {
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
//    public Step flowDemoStep1() {
//        return stepBuilderFactory.get("flowDemoStep1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("flowDemoStep1");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step flowDemoStep2() {
//        return stepBuilderFactory.get("flowDemoStep2")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("flowDemoStep2");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step flowDemoStep3() {
//        return stepBuilderFactory.get("flowDemoStep3")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("flowDemoStep3");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    //创建Flow对象
//    @Bean
//    public Flow flowDemoFlow() {
//        return new FlowBuilder<Flow>("flowDemoFlow")
//                .start(flowDemoStep1())
//                .next(flowDemoStep2())
//                .build();
//    }
//
//    //创建Job对象
//    @Bean
//    public Job flowDemoJob() {
//        return jobBuilderFactory.get("flowDemoJob")
//                .start(flowDemoFlow())
//                .next(flowDemoStep3())
//                .end()
//                .build();
//    }
//}
