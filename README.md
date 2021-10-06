# springbatch介绍

视频地址：https://www.bilibili.com/video/BV1St411U7St

源码地址：https://gitee.com/vahala/springbatchlearn


# 学习笔记

1、instance：执行job失败后重试instance不变，成功了才变

2、execution：每次执行jbo都不一样，不管成功还是失败

3、读取文件的过程中的异常处理

itemStreamReader

（1）open：step开始之前

（2）update：一次chunk之后（成功后才执行）

（3）close：step执行结束后

4、数据库表batch_step_execution_context存储着作业的信息，一般执行过的作业就不再重复执行了，删除里面的记录就可以再次执行了


5、ItemReader：一个一个读取

ItemWriter：一批一批写（根据chunk来决定）
