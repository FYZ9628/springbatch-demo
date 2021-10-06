//package com.example.springbatchdemo.config.decider;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.flow.JobExecutionDecider;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author Administrator
// * @Date 2021/9/25 21:38
// */
//@Configuration
//@EnableBatchProcessing
//public class DeciderDemo {
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
//    public Step deciderDemoStep1() {
//        return stepBuilderFactory.get("deciderDemoStep1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("deciderDemoStep1");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step deciderDemoStep2() {
//        return stepBuilderFactory.get("deciderDemoStep2")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("even");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step deciderDemoStep3() {
//        return stepBuilderFactory.get("deciderDemoStep3")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("odd");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    //创建决策器
//    @Bean
//    public JobExecutionDecider myDecider() {
//        return new MyDecider();
//    }
//
//    //创建任务
//    @Bean
//    public Job deciderdDemoJob() {
//        return jobBuilderFactory.get("deciderDemoJob")
//                .start(deciderDemoStep1())
//                .next(myDecider())
//                .from(myDecider()).on("even").to(deciderDemoStep2())
//                .from(myDecider()).on("odd").to(deciderDemoStep3())
//                //无论step3返回什么，都会回到myDecider中，如果不加下面这句话就会结束了
//                .from(deciderDemoStep3()).on("*").to(myDecider())
//                .end()
//                .build();
//    }
//
//}
