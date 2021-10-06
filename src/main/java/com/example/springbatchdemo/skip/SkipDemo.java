//package com.example.springbatchdemo.skip;
//
//import com.example.springbatchdemo.retry.CustomRetryException;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 错误跳过
// *
// * @Author Administrator
// * @Date 2021/10/6 10:28
// */
//@Configuration
//public class SkipDemo {
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
//    private ItemWriter<String> skipItemWriter;
//
//    @Autowired
//    private ItemProcessor<String, String> skipItemProcessor;
//
//
//    @Bean
//    public Job skipDemoJob() {
//        return jobBuilderFactory.get("skipDemoJob")
//                .start(skipDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step skipDemoStep() {
//        return stepBuilderFactory.get("skipDemoStep")
//                .<String, String>chunk(10)
//                .reader(reader())
//                .processor(skipItemProcessor)
//                .writer(skipItemWriter)
//                .faultTolerant()
//                .skip(CustomRetryException.class)
//                .skipLimit(5)//reader 和 processor 和 writer 加起来的总数 最多不能超过的次数
//                .build();
//    }
//
//
//    @Bean
//    @StepScope
//    public ItemReader<? extends String> reader() {
//        List<String> items = new ArrayList<>();
//        for (int i = 0; i < 60; i++) {
//            items.add(String.valueOf(i));
//        }
//        ListItemReader<String> reader = new ListItemReader<>(items);
//        return reader;
//    }
//
//}
