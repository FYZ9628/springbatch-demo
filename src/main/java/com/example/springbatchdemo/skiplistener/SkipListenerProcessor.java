package com.example.springbatchdemo.skiplistener;

import com.example.springbatchdemo.retry.CustomRetryException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date 2021/10/6 10:54
 */
@Component
public class SkipListenerProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) throws Exception {
        System.out.println("processing item " + item);
        if (item.equalsIgnoreCase("26")) {
            throw new CustomRetryException("Process failed of item 26");
        } else {
            return String.valueOf(Integer.valueOf(item) * -1);
        }
    }
}
