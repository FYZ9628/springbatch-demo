//package com.example.springbatchdemo.config;
//
//import org.springframework.batch.core.ExitStatus;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameter;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.StepExecution;
//import org.springframework.batch.core.StepExecutionListener;
//import org.springframework.batch.core.StepListener;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
// * 传递参数
// *
// * @Author Administrator
// * @Date 2021/9/25 23:46
// */
//@Configuration
//public class ParametersDemo implements StepExecutionListener {
//    //注入创建任务对象的对象
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    //任务的执行由Step决定
//    //注入创建Step对象的对象
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    private Map<String, JobParameter> parameters;
//
//    @Bean
//    public Job parameterJob() {
//        return jobBuilderFactory.get("parameterJob")
//                .start(parameterStep())
//                .build();
//    }
//
//    //Job执行的是step，Job使用的数据肯定是在step中使用，
//    //那我们只需要给step传递数据，如何给step传递参数？
//    //使用监听，使用step级别的监听来传递数据
//    @Bean
//    public Step parameterStep() {
//        return stepBuilderFactory.get("parameterStep")
//                .listener(this)
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println(parameters.get("info"));
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Override
//    public void beforeStep(StepExecution stepExecution) {
//        parameters = stepExecution.getJobParameters().getParameters();
//    }
//
//    @Override
//    public ExitStatus afterStep(StepExecution stepExecution) {
//        return null;
//    }
//}
