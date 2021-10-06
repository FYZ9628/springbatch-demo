//package com.example.springbatchdemo.itemreadermulti;
//
//import com.example.springbatchdemo.itemreaderfile.Customer;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.MultiResourceItemReader;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.mapping.FieldSetMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.file.transform.FieldSet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.validation.BindException;
//
///**
// *  从多个文件中读取数据
// *
// * @Author Administrator
// * @Date 2021/10/4 18:30
// */
//@Configuration
//public class MultiFileItemReaderDemo {
//    //注入创建任务对象的对象
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    //任务的执行由Step决定
//    //注入创建Step对象的对象
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Value("classpath:/file*.txt")
//    private Resource[] fileResources;
//
//    @Autowired
//    @Qualifier("multiFileWriter")
//    private ItemWriter<? super Customer> multiFileWriter;
//
//    @Bean
//    public Job multiFileItemReaderDemoJob() {
//        return jobBuilderFactory.get("multiFileItemReaderDemoJob")
//                .start(multiFileItemReaderDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step multiFileItemReaderDemoStep() {
//        return stepBuilderFactory.get("multiFileItemReaderDemoStep")
//                .<Customer, Customer>chunk(1)
//                .reader(multiFileReader())
//                .writer(multiFileWriter)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public MultiResourceItemReader<Customer> multiFileReader() {
//        MultiResourceItemReader<Customer> reader = new MultiResourceItemReader<Customer>();
//
//        reader.setDelegate(flatFileReader());
//        reader.setResources(fileResources);
//        return reader;
//    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemReader<Customer> flatFileReader() {
//        FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();
//        reader.setResource(new ClassPathResource("customer.txt"));
////        reader.setLinesToSkip(1);//跳过第一行
//        //解析数据
//        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//        tokenizer.setNames(new String[]{"id","firstName","lastName","birthday"});
//
//        //把解析出的一行数据映射为Customer对象
//        DefaultLineMapper<Customer> mapper = new DefaultLineMapper<>();
//        mapper.setLineTokenizer(tokenizer);
//        mapper.setFieldSetMapper(new FieldSetMapper<Customer>() {
//            @Override
//            public Customer mapFieldSet(FieldSet fieldSet) throws BindException {
//                Customer customer = new Customer();
//                customer.setId(fieldSet.readLong("id"));
//                customer.setFirstName(fieldSet.readString("firstName"));
//                customer.setLastName(fieldSet.readString("lastName"));
//                customer.setBirthday(fieldSet.readString("birthday"));
//                return customer;
//            }
//        });
//
//        mapper.afterPropertiesSet();
//        reader.setLineMapper(mapper);
//        return reader;
//    }
//}
