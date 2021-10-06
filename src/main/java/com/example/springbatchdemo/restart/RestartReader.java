package com.example.springbatchdemo.restart;

import com.example.springbatchdemo.itemreaderfile.Customer;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * @Author Administrator
 * @Date 2021/10/5 0:02
 */
@Component("restartReader")
public class RestartReader implements ItemStreamReader<Customer> {

    private FlatFileItemReader<Customer> customerFlatFileItemReader = new FlatFileItemReader<>();
    private Long curLine = 0L;
    private boolean restart = false;
    private ExecutionContext executionContext;

    public RestartReader() {
        customerFlatFileItemReader.setResource(new ClassPathResource("restart.txt"));
//        customerFlatFileItemReader.setLinesToSkip(1);//跳过第一行
        //解析数据
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(new String[]{"id","firstName","lastName","birthday"});

        //把解析出的一行数据映射为Customer对象
        DefaultLineMapper<Customer> mapper = new DefaultLineMapper<>();
        mapper.setLineTokenizer(tokenizer);
        mapper.setFieldSetMapper(new FieldSetMapper<Customer>() {
            @Override
            public Customer mapFieldSet(FieldSet fieldSet) throws BindException {
                Customer customer = new Customer();
                customer.setId(fieldSet.readLong("id"));
                customer.setFirstName(fieldSet.readString("firstName"));
                customer.setLastName(fieldSet.readString("lastName"));
                customer.setBirthday(fieldSet.readString("birthday"));
                return customer;
            }
        });

        mapper.afterPropertiesSet();
        customerFlatFileItemReader.setLineMapper(mapper);
    }

    /**
     * （1）open：step开始之前
     * （2）update：一次chunk之后（成功后才执行）
     * （3）close：step执行结束后
     *
     * @return
     * @throws Exception
     * @throws UnexpectedInputException
     * @throws ParseException
     * @throws NonTransientResourceException
     */
    @Override
    public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Customer customer = null;
        this.curLine++;

        //跳过已经读取的数据，按照chunk的大小来
        if (restart) {
            customerFlatFileItemReader.setLinesToSkip(this.curLine.intValue() - 1);
            restart = false;
            System.out.println("Start reading from line: " + this.curLine);
        }

        customerFlatFileItemReader.open(this.executionContext);
        customer = customerFlatFileItemReader.read();

        //手动制造异常
        if (customer != null && customer.getFirstName().equals("Melodie")) {
            throw new RuntimeException("Something wrong. Customer id: " + customer.getId());
        }
        return customer;
    }

    /**
     * （1）open：step开始之前
     * （2）update：一次chunk之后（成功后才执行）
     * （3）close：step执行结束后
     *
     * @param executionContext
     * @throws ItemStreamException
     */
    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        this.executionContext = executionContext;
        //再次读取时
        if (executionContext.containsKey("curLine")) {
            this.curLine = executionContext.getLong("curLine");
            this.restart = true;
        } else {
            //第一次读取时
            this.curLine = 0L;
            executionContext.put("curLine", this.curLine);
            System.out.println("Start reading from line: " + this.curLine + 1);
        }
    }

    /**
     * （1）open：step开始之前
     * （2）update：一次chunk之后（成功后才执行）
     * （3）close：step执行结束后
     *
     * @param executionContext
     * @throws ItemStreamException
     */
    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.put("curLine", this.curLine);
        System.out.println("currentLine: " + this.curLine);
    }

    /**
     * （1）open：step开始之前
     * （2）update：一次chunk之后（成功后才执行）
     * （3）close：step执行结束后
     *
     * @throws ItemStreamException
     */
    @Override
    public void close() throws ItemStreamException {

    }
}
