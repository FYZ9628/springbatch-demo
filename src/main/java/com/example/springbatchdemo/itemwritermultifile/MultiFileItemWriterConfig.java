package com.example.springbatchdemo.itemwritermultifile;

import com.example.springbatchdemo.itemreaderfile.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 将数据写入到多个文件中
 *
 * @Author Administrator
 * @Date 2021/10/6 7:58
 */
@Configuration
public class MultiFileItemWriterConfig {

    @Bean
    public FlatFileItemWriter<Customer> jsonFilesWriter() throws Exception {
        //把Customer对象转成字符串输出到文件
        FlatFileItemWriter<Customer> writer = new FlatFileItemWriter<Customer>();
        String path = "f:\\customer.txt";
        writer.setResource(new FileSystemResource(path));

        //把Customer对象转成字符串
        writer.setLineAggregator(new LineAggregator<Customer>() {
            ObjectMapper mapper = new ObjectMapper();
            @Override
            public String aggregate(Customer customer) {
                String str = null;
                try {
                    str = mapper.writeValueAsString(customer);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return str;
            }
        });
        writer.afterPropertiesSet();
        return writer;
    }

    @Bean
    public StaxEventItemWriter<Customer> xmlFilesWriter() throws Exception {
        StaxEventItemWriter<Customer> writer = new StaxEventItemWriter<Customer>();
        XStreamMarshaller marshaller = new XStreamMarshaller();
        Map<String, Class> aliases = new HashMap<>();
        aliases.put("customer", Customer.class);
        marshaller.setAliases(aliases);

        writer.setRootTagName("customers");
        writer.setMarshaller(marshaller);

        String path = "f:\\customer.xml";
        writer.setResource(new FileSystemResource(path));
        writer.afterPropertiesSet();

        return writer;
    }

    //输出数据到多个文件
//    @Bean
//    public CompositeItemWriter<Customer> multiFileItemWriter() throws Exception {
//        CompositeItemWriter<Customer> writer = new CompositeItemWriter<Customer>();
//
//        writer.setDelegates(Arrays.asList(jsonFilesWriter(), xmlFilesWriter()));
//
//        writer.afterPropertiesSet();
//        return writer;
//    }

    //实现分类
    @Bean
    public ClassifierCompositeItemWriter<Customer> multiFileItemWriter() {
        ClassifierCompositeItemWriter<Customer> writer = new ClassifierCompositeItemWriter<Customer>();

        writer.setClassifier(new Classifier<Customer, ItemWriter<? super Customer>>() {
            @Override
            public ItemWriter<? super Customer> classify(Customer customer) {
                //按照Customer的id进行分类
                ItemWriter<Customer> writer1 = null;
                try {
                    //能被2整除的写入到txt文件，不能被2整除的写入到xml文件
                    writer1 = customer.getId() % 2 == 0 ? jsonFilesWriter():xmlFilesWriter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return writer1;
            }
        });
        return writer;
    }
}
