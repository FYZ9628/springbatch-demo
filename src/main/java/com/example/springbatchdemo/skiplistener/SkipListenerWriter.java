package com.example.springbatchdemo.skiplistener;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/10/6 10:54
 */
@Component
public class SkipListenerWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String str : list) {
            System.out.println(str);
        }
    }
}