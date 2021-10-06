//package com.example.springbatchdemo.retry;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 错误重试
// *
// * @Author Administrator
// * @Date 2021/10/6 9:57
// */
//@Configuration
//public class RetryDemo {
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
//    private ItemWriter<String> retryItemWriter;
//
//    @Autowired
//    private ItemProcessor<String, String> retryItemProcessor;
//
//
//    @Bean
//    public Job retryDemoJob() {
//        return jobBuilderFactory.get("retryDemoJob")
//                .start(retryDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step retryDemoStep() {
//        return stepBuilderFactory.get("retryDemoStep")
//                .<String, String>chunk(10)
//                .reader(reader())
//                .processor(retryItemProcessor)
//                .writer(retryItemWriter)
//                .faultTolerant()//容错
//                .retry(CustomRetryException.class)
//                .retryLimit(5)//reader 和 processor 和 writer 加起来的总数 最多不能超过的次数
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public ItemReader<String> reader() {
//        List<String> items = new ArrayList<>();
//        for (int i = 0; i < 60; i++) {
//            items.add(String.valueOf(i));
//        }
//        ListItemReader<String> reader = new ListItemReader<>(items);
//        return reader;
//    }
//
//
//}
