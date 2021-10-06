//package com.example.springbatchdemo.config;
//
//import com.example.springbatchdemo.listener.MyChunkListener;
//import com.example.springbatchdemo.listener.MyJobListener;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 监听器
// *
// * @Author Administrator
// * @Date 2021/9/25 23:22
// */
//@Configuration
//public class ListenerDemo {
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
//    public Job listenerJob() {
//        return jobBuilderFactory.get("listenerJob")
//                .start(step1())
//                .listener(new MyJobListener())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<String, String>chunk(2)//每读完两个数据就进行一次输出处理
//                .faultTolerant()
//                .listener(new MyChunkListener())
//                .reader(read())
//                .writer(write())
//                .build();
//    }
//
//    @Bean
//    public ItemReader<String> read() {
//        return new ListItemReader<>(Arrays.asList("java", "spring", "Mybatis"));
//    }
//
//    @Bean
//    public ItemWriter<String> write() {
//        return new ItemWriter<String>() {
//            @Override
//            public void write(List<? extends String> items) throws Exception {
//                for (String item : items) {
//                    System.out.println(item);
//                }
//            }
//        };
//    }
//}
