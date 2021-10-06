//package com.example.springbatchdemo.itemreaderxml;
//
//import com.example.springbatchdemo.itemreaderfile.Customer;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.xml.StaxEventItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.oxm.xstream.XStreamMarshaller;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 从xml文件读取数据
// *
// * @Author Administrator
// * @Date 2021/10/4 17:59
// */
//@Configuration
//public class XmlItemReaderDemo {
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
//    @Qualifier("xmlFileWriter")
//    private ItemWriter<? super Customer> xmlFileWriter;
//
//    @Bean
//    public Job xmlItemReaderDemoJob() {
//        return jobBuilderFactory.get("xmlItemReaderDemoJob")
//                .start(xmlItemReaderDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step xmlItemReaderDemoStep() {
//        return stepBuilderFactory.get("xmlItemReaderDemoStep")
//                .<Customer, Customer>chunk(2)
//                .reader(xmlFileReader())
//                .writer(xmlFileWriter)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public StaxEventItemReader<Customer> xmlFileReader() {
//        StaxEventItemReader<Customer> reader = new StaxEventItemReader<Customer>();
//        reader.setResource(new ClassPathResource("customer.xml"));
//
//        //指定需要处理的根标签
//        reader.setFragmentRootElementName("customer");
//        //把xml转成对象
//        XStreamMarshaller unmarshaller = new XStreamMarshaller();
//        Map<String,Class> map = new HashMap<>();
//        map.put("customer", Customer.class);
//        unmarshaller.setAliases(map);
//        reader.setUnmarshaller(unmarshaller);
//        return reader;
//    }
//
//}
