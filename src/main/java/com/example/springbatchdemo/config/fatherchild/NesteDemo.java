//package com.example.springbatchdemo.config.fatherchild;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.JobRegistry;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.JobStepBuilder;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import java.lang.management.PlatformLoggingMXBean;
//
///**
// * @Author Administrator
// * @Date 2021/9/25 22:53
// */
//@Configuration
//public class NesteDemo {
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
//    @Autowired
//    private Job childJobOne;
//
//    @Autowired
//    private Job childJobTwo;
//
//    @Autowired
//    private JobLauncher launcher;
//
//    @Bean
//    public Job parentJob(JobRepository repository, PlatformTransactionManager transactionManager) {
//        return jobBuilderFactory.get("parentJob")
//                .start(childJob1(repository, transactionManager))
//                .next(childJob2(repository, transactionManager))
//                .build();
//    }
//
//    //返回的是Job类型的step，特殊的step
//    private Step childJob1(JobRepository repository, PlatformTransactionManager transactionManager) {
//        return new JobStepBuilder(new StepBuilder("childJob1"))
//                .job(childJobOne)
//                .launcher(launcher)
//                .repository(repository)
//                .transactionManager(transactionManager)
//                .build();
//    }
//
//    private Step childJob2(JobRepository repository, PlatformTransactionManager transactionManager) {
//        return new JobStepBuilder(new StepBuilder("childJob2"))
//                .job(childJobTwo)
//                .launcher(launcher)
//                .repository(repository)
//                .transactionManager(transactionManager)
//                .build();
//    }
//
//}
