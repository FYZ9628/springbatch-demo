package com.example.springbatchdemo.itemwriterfile;

import com.example.springbatchdemo.itemreaderfile.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

/**
 * 写入数据到txt文件中
 *
 * @Author Administrator
 * @Date 2021/10/5 23:54
 */
@Configuration
public class FileItemWriterConfig {

    @Bean
    public FlatFileItemWriter<Customer> fileItemWriter() throws Exception {
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
}
