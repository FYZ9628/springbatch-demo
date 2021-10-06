//package com.example.springbatchdemo.itemwritermultifile;
//
//import com.example.springbatchdemo.itemreaderfile.Customer;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemStreamWriter;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 从数据库读取数据，将数据写到多个文件中(txt、xml)
// *
// * @Author Administrator
// * @Date 2021/10/6 7:33
// */
//@Configuration
//public class MultiFileItemWriterDemo {
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
//    @Qualifier("multiFileItemWriter")
//    private ItemWriter<Customer> multiFileItemWriter;
//
//
//    //----只有用 ClassifierCompositeItemWriter 才需要将这两个注入----
//    @Autowired
//    @Qualifier("jsonFilesWriter")
//    private ItemStreamWriter<Customer> jsonFilesWriter;
//
//    @Autowired
//    @Qualifier("xmlFilesWriter")
//    private ItemStreamWriter<Customer> xmlFilesWriter;
//    //----只有用 ClassifierCompositeItemWriter 才需要将这两个注入----
//
//    @Bean
//    public Job multiFileItemWriterDemoJob2() {
//        return jobBuilderFactory.get("multiFileItemWriterDemoJob2")
//                .start(multiFileItemWriterDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step multiFileItemWriterDemoStep() {
//        return stepBuilderFactory.get("multiFileItemWriterDemoStep")
//                .<Customer, Customer>chunk(2)
//                .reader(dbJdbcReader)
//                .writer(multiFileItemWriter)
//                .stream(jsonFilesWriter)
//                .stream(xmlFilesWriter)
//                .build();
//    }
//}
