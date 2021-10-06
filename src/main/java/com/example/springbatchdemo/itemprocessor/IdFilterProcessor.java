package com.example.springbatchdemo.itemprocessor;

import com.example.springbatchdemo.itemreaderfile.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * 过滤id为偶数的
 *
 * @Author Administrator
 * @Date 2021/10/6 8:59
 */
@Component
public class IdFilterProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        if (customer.getId() % 2 == 0) {
            return customer;
        } else {
            return null; //如果返回为null，这个对象就不会传给itemWriter，相当于把该对象过滤掉
        }
    }
}
