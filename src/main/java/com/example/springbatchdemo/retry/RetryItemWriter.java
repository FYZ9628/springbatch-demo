package com.example.springbatchdemo.retry;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/10/6 10:00
 */
@Component
public class RetryItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
