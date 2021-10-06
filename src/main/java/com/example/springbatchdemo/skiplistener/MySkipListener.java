package com.example.springbatchdemo.skiplistener;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date 2021/10/6 10:50
 */

@Component
public class MySkipListener implements SkipListener<String, String> {
    @Override
    public void onSkipInRead(Throwable throwable) {

    }

    @Override
    public void onSkipInWrite(String s, Throwable throwable) {

    }

    @Override
    public void onSkipInProcess(String item, Throwable throwable) {
        System.out.println(item + "occur exception" + throwable);
    }
}
