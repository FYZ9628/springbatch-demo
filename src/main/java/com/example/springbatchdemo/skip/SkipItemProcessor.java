package com.example.springbatchdemo.skip;

import com.example.springbatchdemo.retry.CustomRetryException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date 2021/10/6 10:35
 */
@Component
public class SkipItemProcessor implements ItemProcessor<String, String> {

    private int attemptCount = 0;

    @Override
    public String process(String item) throws Exception {
        System.out.println("processing item " + item);
        if (item.equalsIgnoreCase("26")) {
            attemptCount++;
            if (attemptCount >= 3) {
                System.out.println("Retried " + attemptCount + " times success.");
                return String.valueOf(Integer.valueOf(item) * -1);
            } else {
                System.out.println("Processed the " + attemptCount + " times fail.");
                throw new CustomRetryException("Process faild. Attempt:" + attemptCount);
            }
        } else {
            return String.valueOf(Integer.valueOf(item) * -1);
        }
    }
}
