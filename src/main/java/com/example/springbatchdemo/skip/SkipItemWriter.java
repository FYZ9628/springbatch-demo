package com.example.springbatchdemo.skip;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/10/6 10:39
 */
@Component
public class SkipItemWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
