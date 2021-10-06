package com.example.springbatchdemo.itemprocessor;

import com.example.springbatchdemo.itemreaderfile.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 处理数据：将firstName字符全改为大写
 *
 * @Author Administrator
 * @Date 2021/10/6 8:53
 */
@Component
public class FirstNameUpperProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        Customer cus = new Customer();
        cus.setId(customer.getId());
        cus.setFirstName(customer.getFirstName().toUpperCase());
        cus.setLastName(customer.getLastName());
        cus.setBirthday(customer.getBirthday());
        return cus;
    }
}
