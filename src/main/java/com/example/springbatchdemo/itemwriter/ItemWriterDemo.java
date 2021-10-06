//package com.example.springbatchdemo.itemwriter;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * itemWriter介绍
// *
// * @Author Administrator
// * @Date 2021/10/5 17:28
// */
//@Configuration
//public class ItemWriterDemo {
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
//    @Qualifier("myWriter")
//    private ItemWriter<? super String> myWriter;
//
//    @Bean
//    public Job itemWriterDemoJob() {
//        return jobBuilderFactory.get("itemWriterDemoJob")
//                .start(itemWriterDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemWriterDemoStep() {
//        return stepBuilderFactory.get("itemWriterDemoStep")
//                .<String, String>chunk(5)
//                .reader(myRead())
//                .writer(myWriter)
//                .build();
//    }
//
//    @Bean
//    public ItemReader<? extends String> myRead() {
//        List<String> items = new ArrayList<>();
//        for (int i = 1; i <= 50; i++) {
//            items.add("java" + i);
//        }
//        return new ListItemReader<String>(items);
//    }
//}
