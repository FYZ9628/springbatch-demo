//package com.example.springbatchdemo.itemwriterdb;
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
// * 把数据写入到数据库中（mysql）
// * 先从文件（txt）中读取数据，再将数据写入到数据库中（mysql）
// *
// * @Author Administrator
// * @Date 2021/10/5 19:19
// */
//@Configuration
//public class ItemWriterDbDemo {
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
//    @Qualifier("flatFileReader")
//    private ItemReader<Customer> flatFileReader;
//
//    @Autowired
//    @Qualifier("itemWriterDb")
//    private ItemWriter<Customer> itemWriterDb;
//
//    @Bean
//    public Job itemWriterDbDemoJob() {
//        return jobBuilderFactory.get("itemWriterDbDemoJob")
//                .start(itemWriterDbDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemWriterDbDemoStep() {
//        return stepBuilderFactory.get("itemWriterDbDemoStep")
//                .<Customer, Customer>chunk(2)
//                .reader(flatFileReader)
//                .writer(itemWriterDb)
//                .build();
//    }
//}
