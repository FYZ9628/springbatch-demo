//package com.example.springbatchdemo.itemreaderdb;
//
//import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 从数据库中读取数据
// *
// * @Author Administrator
// * @Date 2021/9/30 23:06
// */
//@Configuration
//public class ItemReaderDbDemo {
//
//    //注入创建任务对象的对象
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    //任务的执行由Step决定
//    //注入创建Step对象的对象
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    @Qualifier("dbJdbcWriter")
//    private ItemWriter<? super User> dbJdbcWriter;
//
//    @Bean
//    public Job itemReaderDbJob() {
//        return jobBuilderFactory.get("itemReaderDbJob")
//                .start(itemReaderDbStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemReaderDbStep() {
//        return stepBuilderFactory.get("itemReaderDbStep")
//                .<User, User>chunk(2)
//                .reader(dbJdbcReader())
//                .writer(dbJdbcWriter)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public JdbcPagingItemReader<User> dbJdbcReader() {
//        JdbcPagingItemReader<User> reader = new JdbcPagingItemReader<User>();
//        reader.setDataSource(dataSource);
//        reader.setFetchSize(2);
//        //把读取到的记录转换成User对象
//        reader.setRowMapper(new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                User user = new User();
//                user.setId(rs.getInt(1));
//                user.setUsername(rs.getString(2));
//                user.setPassword(rs.getString(3));
//                user.setAge(rs.getInt(4));
//                return user;
//            }
//        });
//        //指定sql语句
//        MySqlPagingQueryProvider provider = new MySqlPagingQueryProvider();
//        provider.setSelectClause("id,username,password,age");
//        provider.setFromClause("from user");
//
//        //指定根据哪个字段进行排序
//        Map<String, Order> sort = new HashMap<>(1);
//        sort.put("id", Order.ASCENDING);    //升序
//        provider.setSortKeys(sort);
//
//        reader.setQueryProvider(provider);
//        return reader;
//    }
//
//
//}
