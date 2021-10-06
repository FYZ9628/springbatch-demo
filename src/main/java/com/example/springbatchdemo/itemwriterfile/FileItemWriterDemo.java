//package com.example.springbatchdemo.itemwriterfile;
//
//import com.example.springbatchdemo.itemreaderfile.Customer;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 写数据到普通文件中(txt)
// * 先从数据库（mysql）中读取数据，再写入到文件中(txt)
// *
// * @Author Administrator
// * @Date 2021/10/5 23:38
// */
//@Configuration
//public class FileItemWriterDemo {
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
//    @Qualifier("dbJdbcReader")
//    private ItemReader<? extends Customer> dbJdbcReader;
//
//    @Autowired
//    @Qualifier("fileItemWriter")
//    private ItemWriter<? super Customer> fileItemWriter;
//
//    @Bean
//    public Job fileItemWriterDemoJob() {
//        return jobBuilderFactory.get("fileItemWriterDemoJob")
//                .start(fileItemWriterDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step fileItemWriterDemoStep() {
//        return stepBuilderFactory.get("fileItemWriterDemoStep")
//                .<Customer, Customer>chunk(2)
//                .reader(dbJdbcReader)
//                .writer(fileItemWriter)
//                .build();
//    }
//}
