//package com.example.springbatchdemo.itemprocessor;
//
//import com.example.springbatchdemo.itemreaderfile.Customer;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.CompositeItemProcessor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 处理数据
// *
// * @Author Administrator
// * @Date 2021/10/6 8:43
// */
//@Configuration
//public class ItemProcessorDemo {
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
//    @Qualifier("dbJdbcReader")
//    private ItemReader<Customer> dbJdbcReader;
//
//    @Autowired
//    @Qualifier("dbFileWriter")
//    private ItemWriter<Customer> dbFileWriter;
//
//    @Autowired
//    private ItemProcessor<Customer, Customer> firstNameUpperProcessor;
//
//    @Autowired
//    private ItemProcessor<Customer, Customer> idFilterProcessor;
//
//    @Bean
//    public Job itemProcessorDemoJob() {
//        return jobBuilderFactory.get("itemProcessorDemoJob")
//                .start(itemProcessorDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemProcessorDemoStep() {
//        return stepBuilderFactory.get("itemProcessorDemoStep")
//                .<Customer, Customer>chunk(2)
//                .reader(dbJdbcReader)
//                .processor(process())
//                .writer(dbFileWriter)
//                .build();
//    }
//
//    //有多种处理数据的方式
//    @Bean
//    public CompositeItemProcessor<Customer, Customer> process() {
//        CompositeItemProcessor<Customer, Customer> processor = new CompositeItemProcessor<Customer, Customer>();
//        List<ItemProcessor<Customer, Customer>> delegates = new ArrayList<>();
//        delegates.add(firstNameUpperProcessor);
//        delegates.add(idFilterProcessor);
//
//        processor.setDelegates(delegates);
//        return processor;
//    }
//
//}
