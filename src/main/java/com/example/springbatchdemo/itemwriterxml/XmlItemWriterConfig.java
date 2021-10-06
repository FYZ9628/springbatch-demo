package com.example.springbatchdemo.itemwriterxml;

import com.example.springbatchdemo.itemreaderfile.Customer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

/**
 * 写入数据到xml文件中
 *
 * @Author Administrator
 * @Date 2021/10/6 0:15
 */
@Configuration
public class XmlItemWriterConfig {

    @Bean
    public StaxEventItemWriter<Customer> xmlItemWriter() throws Exception {
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
}
