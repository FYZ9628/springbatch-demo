//package com.example.springbatchdemo.itemreader;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 读写数据（基础类型：String）
// *
// * @Author Administrator
// * @Date 2021/9/26 0:29
// */
//@Configuration
//public class ItemReaderDemo {
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
//    public Job itemReaderDemoJob() {
//        return jobBuilderFactory.get("itemReaderDemoJob")
//                .start(itemReaderDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemReaderDemoStep() {
//        return stepBuilderFactory.get("itemReaderDemoStep")
//                //读取和输出都是Sring类型，每读取两个数据就输出一次
//                .<String, String>chunk(2)
//                .reader(itemReaderDemoRead())
//                .writer(list -> {
//                    for (String item : list) {
//                        System.out.println(item + "...");
//                    }
//                }).build();
//    }
//
//    @Bean
//    public MyReader itemReaderDemoRead() {
//        List<String> data = Arrays.asList("cat", "dog", "pig", "duck");
//        return new MyReader(data);
//    }
//}
