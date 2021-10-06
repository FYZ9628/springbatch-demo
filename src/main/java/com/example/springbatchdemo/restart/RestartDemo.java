//package com.example.springbatchdemo.restart;
//
//import com.example.springbatchdemo.itemreaderfile.Customer;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemStreamReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 读取的时候处理异常
// *
// * @Author Administrator
// * @Date 2021/10/5 0:02
// */
//@Configuration
//public class RestartDemo {
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
//    @Qualifier("restartReader")
//    private ItemStreamReader<? super Customer> restartReader;
//
//    @Autowired
//    @Qualifier("restartWriter")
//    private ItemWriter<? super Customer> restartWriter;
//
//
//    @Bean
//    public Job restartReaderDemoJob() throws Exception {
//        return jobBuilderFactory.get("restartReaderDemoJob")
//                .start(restartReaderDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step restartReaderDemoStep() throws Exception {
//        return stepBuilderFactory.get("restartReaderDemoStep")
//                .<Customer, Customer>chunk(5)
//                .reader((ItemReader<? extends Customer>) restartReader)
//                .writer(restartWriter)
//                .build();
//    }
//
//
//}
