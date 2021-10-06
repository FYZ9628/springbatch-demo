//package com.example.springbatchdemo.error;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
///**
// * 错误处理
// *
// * @Author Administrator
// * @Date 2021/10/6 9:45
// */
//@Configuration
//public class ErrorDemo {
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
//    public Job errorDemoJob() {
//        return jobBuilderFactory.get("errorsDemoJob")
//                .start(errorDemoStep1())
//                .next(errorDemoStep2())
//                .build();
//    }
//
//    @Bean
//    public Step errorDemoStep1() {
//        return stepBuilderFactory.get("errorDemoStep1")
//                .tasklet(errorHandling())
//                .build();
//    }
//
//    @Bean
//    public Step errorDemoStep2() {
//        return stepBuilderFactory.get("errorDemoStep2")
//                .tasklet(errorHandling())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public Tasklet errorHandling() {
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                Map<String, Object> stepExecutionContext = chunkContext.getStepContext().getStepExecutionContext();
//                if (stepExecutionContext.containsKey("qianfeng")) {
//                    System.out.println("The second run will success");
//                    return RepeatStatus.FINISHED;
//                } else {
//                    System.out.println("The first run will fail");
//                    chunkContext.getStepContext().getStepExecution().getExecutionContext().put("qianfeng", true);
//                    throw new RuntimeException("error ...");
//                }
//            }
//        };
//    }
//
//}
