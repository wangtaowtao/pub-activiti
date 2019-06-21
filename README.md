# pub-activiti
> 集成spring，springMVC，Mybatis的工作流Maven测试项目，主要工作业务和流程业务的项目演示

 项目主要用来练习工作流的基本流程，和熟悉spring集成的activiti项目搭建，了解activiti各组件的使用

## 如何启动项目
1. 新建activiti的数据库
2. 将resources下的db.sql在数据库中运行(生成业务需要的表请假表和员工表)
3. 修改profile->dev.properties的数据库配置
4. 右键项目->Run as->maven build..->在页面Goals:处输入命令jetty:run(启动8888端口)
5. 浏览器输入localhost:8888


![首页](https://raw.githubusercontent.com/wangtaowtao/image/master/activiti/activiti-index.png)
