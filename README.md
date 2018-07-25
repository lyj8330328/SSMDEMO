# 一、SSM整合  
<font size="4">
Spring+SpringMVC+Mybatis的整合思路：  
  
- 创建Maven项目
- 导入相关依赖
- 配置web.xml
- 配置Spring
- 配置Spring MVC
- 配置Mybatis
- 应用：使用连接池、分页、CRUD、事务管理、JSON返回数据
</font>  

# 二、项目结构（使用IDEA）
![SSM目录结构](https://image-1255440489.cos.ap-chengdu.myqcloud.com/SSM%E7%9B%AE%E5%BD%95%E7%BB%93%E6%9E%84.png)
# 三、搭建过程
## 1.使用IDEA创建maven工程，然后导入以下依赖。 <!--more-->
```bash
<properties>
        <spring.version>4.1.3.RELEASE</spring.version>
        <pagehelper.version>4.1.6</pagehelper.version>
        <mysql.version>5.1.6</mysql.version>
        <mybatis.spring.version>1.3.2</mybatis.spring.version>
        <mybatis.version>3.4.1</mybatis.version>
        <junit.version>4.12</junit.version>
        <jstl.version>1.2</jstl.version>
        <jsqlparser.version>1.0</jsqlparser.version>
        <jackson.version>1.2.7</jackson.version>
        <servlet-api.version>3.1.0</servlet-api.version>
        <druid.version>1.0.18</druid.version>
        <log4j.version>1.2.16</log4j.version>
        <commons-logging.version>1.2</commons-logging.version>
        <commons-fileupload.version>1.2.1</commons-fileupload.version>
        <commons-io.version>1.3.2</commons-io.version>
        <commons-lang.version>2.6</commons-lang.version>
        <aopalliance.version>1.0</aopalliance.version>
        <mybatis-generator.version>1.3.5</mybatis-generator.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>${mybatis.spring.version}</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>

        <!-- 连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>


        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>


        <!-- JSP相关 -->
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>${jstl.version}</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>${servlet-api.version}</version>
            <scope>provided</scope>
        </dependency>

        <!-- pageHelper -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>${pagehelper.version}</version>
        </dependency>

        <!--jsqlparser -->
        <dependency>
            <groupId>com.github.jsqlparser</groupId>
            <artifactId>jsqlparser</artifactId>
            <version>${jsqlparser.version}</version>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>

        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>${commons-logging.version}</version>
        </dependency>

        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>${commons-fileupload.version}</version>
        </dependency>

        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>${commons-io.version}</version>
        </dependency>

        <dependency>
            <groupId>commons-lang</groupId>
            <artifactId>commons-lang</artifactId>
            <version>${commons-lang.version}</version>
        </dependency>

        <dependency>
            <groupId>aopalliance</groupId>
            <artifactId>aopalliance</artifactId>
            <version>${aopalliance.version}</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>${mybatis-generator.version}</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.13</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.1.4</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.1</version>
        </dependency>
    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <!-- 资源文件拷贝插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.7</version>
                <configuration>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <!-- java编译插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
        </plugins>
        <pluginManagement>
            <plugins>
                <!-- 配置Tomcat插件 -->
                <plugin>
                    <groupId>org.apache.tomcat.maven</groupId>
                    <artifactId>tomcat7-maven-plugin</artifactId>
                    <version>2.2</version>
                </plugin>
            </plugins>
        </pluginManagement>

        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                    <include>**/*.tld</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
```
## 2.配置web.xml
<font size="4">  

- 配置Spring的IOC容器
```bash
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```
- 配置Spring MVC的核心控制器
```bash
<servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- spring mvc的配置文件 -->
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:springMVC.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>mvc-dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```
将不同功能的配置文件分开，所以在这里引入了两个外部的xml文件applicationContext.xml和springMVC.xml，它们是对Spring和Spring MVC进行具体配置。
- 过滤器的设置
    - 编码方式（配置在所有过滤器前）
    ```bash
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
	<filter-mapping>
		<filter-name>characterEncodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
    ```
    - RESTful风格（在应用部分，进行CRUD操作时使用rest的风格，需要配置HiddenHttpMethodFilter）
    ```bash
    <filter>
		<filter-name>hiddenHttpMethodFilter</filter-name>
		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>hiddenHttpMethodFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
    ```
</font>  

## 3.配置Spring（applicationContext.xml）
<font size="4">  

- 配置自动扫描包  
包含Controller和ControllerAdvice注解的bean交给SpringMVC来扫描，Spring就不再扫描了，所以要把这两个注解排除在外。
```bash
<context:component-scan base-package="com.li">
    <!-- 去除由Springmvc负责扫描的注解 -->
    <context:exclude-filter type="annotation"
        expression="org.springframework.stereotype.Controller" />
    <context:exclude-filter type="annotation"
        expression="org.springframework.web.bind.annotation.ControllerAdvice" />
</context:component-scan>
```
- 数据库配置文件（db.properties）
```bash
jdbc.username=root
jdbc.password=123456
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc\:mysql\://127.0.0.1\:3306/sh?characterEncoding\=UTF-8&useSSL\=false
```
并且在Spring中加载此资源文件
```bash
<bean id="propertyPlaceHolderConfigurer"
    class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="locations">
        <list>
            <value>classpath:db.properties</value>
        </list>
    </property>
</bean>
```
- 配置DataSource(二选一)
    - 普通的jdbc连接数据库
    ```bash
    <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" 
		id="dataSource"> <property name="username" value="${jdbc.username}"></property> 
		<property name="password" value="${jdbc.password}"></property> <property 
		name="driverClassName" value="${jdbc.driverClassName}"></property> <property 
		name="url" value="${jdbc.url}"></property> 
	</bean> 
    ```
    - 使用连接池连接数据库(Druid)    
    ```bash
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
		init-method="init" destroy-method="close">
		<!-- 基本属性 -->
		<property name="username" value="${jdbc.username}"></property>
		<property name="password" value="${jdbc.password}"></property>
		<property name="driverClassName" value="${jdbc.driverClassName}"></property>
		<property name="url" value="${jdbc.url}"></property>

		<!-- 配置初始化大小、最小、最大 -->
		<property name="initialSize" value="3" />
		<property name="minIdle" value="3" />
		<property name="maxActive" value="20" />

		<!-- 配置获取连接等待超时的时间 -->
		<property name="maxWait" value="60000" />

		<!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
		<property name="timeBetweenEvictionRunsMillis" value="60000" />

		<!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
		<property name="minEvictableIdleTimeMillis" value="300000" />

		<property name="validationQuery" value="SELECT 1" />
		<property name="testWhileIdle" value="true" />
		<property name="testOnBorrow" value="false" />
		<property name="testOnReturn" value="false" />

		<!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
		<property name="poolPreparedStatements" value="true" />
		<property name="maxPoolPreparedStatementPerConnectionSize" value="20" />
	</bean>
    ```
</font>  

## 4.配置Mybatis（继续在Spring中配置）
<font size="4">  

- 配置SqlSession：配置对应的pojo，引用已经配好的数据源，因为在应用中有分页操作，所以同时配置第三方插件PageHelper。
```bash
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
    <!-- 自动扫描com.li.pojo下的类型 -->
    <property name="typeAliasesPackage" value="com.li.pojo"></property>
    <!-- 配置数据源 -->
    <property name="dataSource" ref="dataSource"></property>

    <!-- 配置PageHelper -->
    <property name="plugins">
        <array>
            <bean class="com.github.pagehelper.PageInterceptor">
                <property name="properties">
                    <value>
                        helperDialect=mysql
                        reasonable=true
                        supportMethodsArguments=true
                        params=count=countSql
                        autoRuntimeDialect=true
                    </value>
                </property>
            </bean>
        </array>
    </property>
</bean>
```
- 配置Mapper：Demo中使用Mybatis的注解方式进行映射，没有单独的xml映射文件，所以直接扫描mapper下的类即可。
```bash
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	<property name="basePackage" value="com.li.mapper"></property>
</bean>
```  
</font>  

## 5.配置Spring mvc(springMVC.xml)  

<font size="4">  

- 配置自动扫描包  
在context:component-scan可以添加use-default-filters，spring配置中的use-default-filters用来指示是否自动扫描带有@Component、@Repository、@Service和@Controller的类。默认为true，即默认扫描。
```bash
<context:component-scan base-package="com.li"
    use-default-filters="false">
    <context:include-filter type="annotation"
        expression="org.springframework.stereotype.Controller" />
    <context:include-filter type="annotation"
        expression="org.springframework.web.bind.annotation.ControllerAdvice" />
</context:component-scan>
```
- 配置视图解析器
```bash
<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
    <property name="prefix" value="/WEB-INF/jsp/"></property>
    <property name="suffix" value=".jsp"></property>
</bean>
```
- 配置加载静态资源（访问html,css,js,images等）
```bash
<mvc:default-servlet-handler />
```
- 配置注解驱动（访问路径与方法匹配）  
虽然在web.xml中已经提供了过滤器进行SSM的中文处理，但是json处理还要加点额外的内容,具体如下所示：
```bash
<mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <property name="supportedMediaTypes" value="text/plain;charset=UTF-8" />
        </bean>
    </mvc:message-converters>    
</mvc:annotation-driven>
```
</font>

## 6.日志文件配置（log4j.properties）
```bash
# Global logging configuration
log4j.rootLogger=ERROR, stdout
# MyBatis logging configuration...
log4j.logger.com.how2java=TRACE
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```
## 7.pojo（Category.java）
```bash
package com.li.pojo;

public class Category {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
```
## 8.mapper（CategoryMapper.java）
```bash
package com.li.mapper;


import com.li.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface CategoryMapper {
	@Insert("insert into category(name) values (#{name})")
	void add(Category category);

	@Delete("delete from category where id= #{id}")
	void delete(int id);

	@Select("select * from category where id= #{id}")
	Category get(int id);

	@Update("update category set name=#{name} where id=#{id}")
	void update(Category category);

	@Select("select * from category")
	List<Category> list();

}
```
## 9.service（CategoryService.java、CategoryServiceImpl.java）
CategoryService.java
```bash
package com.li.service;


import com.li.pojo.Category;

import java.util.List;

public interface CategoryService {
	List<Category> list();

	void add(Category category);

	void update(Category category);

	void delete(int id);

	Category get(int id);

	void addTwo();//用于测试事务

}
```
CategoryServiceImpl.java
```bash
package com.li.service.impl;

import java.util.List;

import com.li.mapper.CategoryMapper;
import com.li.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.li.pojo.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryMapper.list();
	}

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.add(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.update(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryMapper.delete(id);
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void addTwo() {
		// TODO Auto-generated method stub
		Category c1 = new Category();
		c1.setName("短的名字");
		categoryMapper.add(c1);

		Category c2 = new Category();
		c2.setName("放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下");
		categoryMapper.add(c2);
	}

}

```
## 10.controller（CategoryController.java）
```bash
package com.li.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.li.pojo.Category;
import com.li.service.CategoryService;


@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		PageHelper.startPage(start, size, "id desc");
		List<Category> categories = categoryService.list();
		PageInfo<Category> pageInfo = new PageInfo<>(categories);
		model.addAttribute("pageInfo", pageInfo);
		// categoryService.addTwo();
		return "listCategory";
	}

	/**
	 * 保存一条记录
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/category", method = RequestMethod.PUT)
	// @PutMapping("/category")
	public String saveCategory(Category category) {
		categoryService.add(category);
		return "redirect:/category";
	}

	/**
	 * 删除一条记录
	 * 
	 * @param category
	 * @return
	 */
	// @DeleteMapping("/category/{id}")
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public String deleteCategory(Category category) {
		categoryService.delete(category.getId());
		return "redirect:/category";
	}

	/**
	 * 更新一条记录
	 * 
	 * @param category
	 * @param start
	 * @return
	 */
	// @PostMapping("/category/{id}")
	@RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
	public String updateCategory(Category category, int start) {
		categoryService.update(category);
		return "redirect:/category?start=" + start;
	}

	/**
	 * 跳转到编辑页
	 * 
	 * @param model
	 * @param id
	 * @param start
	 * @return
	 */
	// @GetMapping("/category/{id}")
	@RequestMapping(value = "/category/{start}/{id}", method = RequestMethod.GET)
	public String editCategory(Model model, @PathVariable("id") int id, @PathVariable("start") int start) {
		Category category = categoryService.get(id);
		model.addAttribute("category", category);
		model.addAttribute("start", start);
		return "editCategory";
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}

}
```
## 11.视图层（editCategory.jsp、listCategory.jsp）
listCategory.jsp
```bash
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'listCategory.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<div style="width:500px;margin:20px auto;text-align: center">
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="c" varStatus="st">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td><a href="category/${pageInfo.pageNum }/${c.id }">编辑</a></td>
				<td>
					<form  action="category/${c.id }" method="post">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <button type="submit">删除</button>
                    </form>
                </td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<div style="text-align:center">
		<a href="category?start=1">首  页</a>
        <a href="category?start=${pageInfo.pageNum-1}">上一页</a>
        <a href="category?start=${pageInfo.pageNum+1}">下一页</a>
        <a href="category?start=${pageInfo.pages}">末  页</a>
	</div>
	<form action="category" method="post">
            <!--修改提交方式为PUT-->
            <input type="hidden" name="_method" value="PUT"/>
            name:<input name="name"/><br/>
            <button type="submit">提交</button>
     </form>
</div>
</body>
</html>
```
editCategory.jsp
```bash
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div style="margin:0px auto; width:500px">
		<form action="category/${category.id}" method="post">
			name: <input name="name" value="${category.name}"> <br>
			<input name="start" value="${start }" type="hidden"/>
			<button type="submit">提交</button>
		</form>
	</div>
</body>
</html>

```
# 四、应用
## 1.连接池
<font size="4">
<1>Druid 连接池简介  

Druid首先是一个数据库连接池。Druid是目前最好的数据库连接池，在功能、性能、扩展性方面，都超过其他数据库连接池，包括DBCP、C3P0、BoneCP、Proxool、JBoss DataSource。Druid已经在阿里巴巴部署了超过600个应用，经过一年多生产环境大规模部署的严苛考验。Druid是一个JDBC组件，它包括三个部分：  

- 基于Filter－Chain模式的插件体系。
- DruidDataSource 高效可管理的数据库连接池。
- SQLParser  

<2>Druid的功能  
- 替换DBCP和C3P0。Druid提供了一个高效、功能强大、可扩展性好的数据库连接池。
- 可以监控数据库访问性能，Druid内置提供了一个功能强大的StatFilter插件，能够详细统计SQL的执行性能，这对于线上分析数据库访问性能有帮助。
- 数据库密码加密。直接把数据库密码写在配置文件中，这是不好的行为，容易导致安全问题。DruidDruiver和DruidDataSource都支持PasswordCallback。
- SQL执行日志，Druid提供了不同的LogFilter，能够支持Common-Logging、Log4j和JdkLog，你可以按需要选择相应的LogFilter，监控你应用的数据库访问情况。
- 扩展JDBC，如果你要对JDBC层有编程的需求，可以通过Druid提供的Filter机制，很方便编写JDBC层的扩展插件。
</font>  

## 2.分页  
<font size="4">  

分页采用第三方插件PageHelper，在配置Mybatis的时候同时配置pagehelper插件。  
注：如果采用java方式配置，为什么不起作用？在springboot中就可以。
</font>  

## 3.CRUD
<font size="4">  

采用RESTful风格：增加PUT、删除DELETE、获取GET、修改POST
</font>
## 4.事务
<font size="4">  
设置Category中name字段为varchar(20)。在CategoryService中添加新方法——addTwo()，同时添加两个对象，一个名字在范围内，另一个超出20个字符的范围。如果不进行事务管理，那么其中名字合法的对象就会被插入，不合法的就不插入。如果进行事务管理，因为这两个操作发生在一个事务当中，当一个对象名字不合法，那么另一个对象也无法插入。  

- 进行事务配置  
修改applicationContext.xml，添加事务管理器和事务注解扫描器。
```bash
<tx:annotation-driven transaction-manager="transactionManager" />
<bean id="transactionManager"
    class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource" />
</bean>
```
- 使用注解方式
```bash
@Override
@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
public void addTwo() {
    // TODO Auto-generated method stub
    Category c1 = new Category();
    c1.setName("短的名字");
    categoryMapper.add(c1);

    Category c2 = new Category();
    c2.setName("放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下");
    categoryMapper.add(c2);
}
```
- 使用XML配置方式（支持AOP）
```bash
<tx:advice id="txadvice" transaction-manager="transactionManager">
    <tx:attributes>
        <tx:method name="add*" propagation="REQUIRED" rollback-for="Exception" />
        <tx:method name="del*" propagation="REQUIRED" rollback-for="Exception" />
        <tx:method name="edit*" propagation="REQUIRED"
            rollback-for="Exception" />
        <tx:method name="update*" propagation="REQUIRED"
            rollback-for="Exception" />
        <tx:method name="list*" propagation="REQUIRED"
            rollback-for="Exception" />
    </tx:attributes>
</tx:advice>

<aop:config>
    <aop:pointcut id="serviceMethod"
        expression="execution(* com.li.service.*.*(..))" />
    <aop:advisor pointcut-ref="serviceMethod" advice-ref="txadvice" />
</aop:config>
```
- 测试类
```bash
package com.li.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.li.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCategory {

	@Autowired
	private CategoryService categoryService;

	@Test
	public void test() {
		categoryService.addTwo();
	}
}
```
- 测试结果
![SSM事务测试](https://image-1255440489.cos.ap-chengdu.myqcloud.com/SSM%E4%BA%8B%E5%8A%A1%E6%B5%8B%E8%AF%95.jpg)
</font>  

## 5.JSON
<font size="4">  

- 新增CategoryJsonController.java用来返回JSON数据
```bash
package com.li.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import com.li.pojo.Category;
import com.li.service.CategoryService;

import java.util.List;

@Controller
public class CategoryJsonController {

	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category) {
		System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:" + category);
		categoryService.add(category);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/getOneCategory/{id}")
	public String getOneCategory(@PathVariable("id") int id) {
		Category c = categoryService.get(id);
		JSONObject json = new JSONObject();
		json.put("category", JSONObject.toJSON(c));
		return json.toJSONString();
	}

	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory() {
		List<Category> cs = categoryService.list();
		return JSONObject.toJSON(cs).toString();
	}
}
```
- 测试：使用访问静态资源（html）或者使用Postman来进行测试。
    - 添加三个html文件，使用ajax请求JSON数据（注意静态资源存放的位置，位于webapp下，与WEB-INF是同一级的，这样才可以访问）    
    1.获取全部数据（getMany.html）
    ```bash
    <!DOCTYPE html>
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
    <title>用AJAX以JSON方式获取数据</title>  
    <script type="text/javascript" src="jquery.min.js"></script>  
    </head>  
    <body>  
        <input type="button" value="通过AJAX获取多个Hero对象111" id="sender">   
        <div id="messageDiv"></div>      
        <script>  
        $('#sender').click(function(){  
            var url="getManyCategory";  
            $.post(
                    url, 
                    function(data) { 
                        console.log(data);
                        var categorys = $.parseJSON(data);
                        console.log(categorys.length);

                        for(i in categorys){
                            var old = $("#messageDiv").html();
                            var category = categorys[i];
                            $("#messageDiv").html(old + "<br>"+category.id+"   -----   "+category.name);  
                        }
            });   
        });  
        </script>  
    </body>  
    </body>
    </html>
    ```  
    2.获取一条数据（getOne.html）
    ```bash
    <!DOCTYPE html>
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
    <title>用AJAX以JSON方式获取数据</title>  
    <script type="text/javascript" src="jquery.min.js"></script>  
    </head>  
    <body>  
        <input type="button" value="通过AJAX获取一个Hero对象---" id="sender">   
    
        <div id="messageDiv"></div>  
        
        <script>  
        $('#sender').click(function(){  
            var url="getOneCategory/100";
            $.post(
                    url, 
                    function(data) {
                        var json=JSON.parse(data);  
                        var name =json.category.name;  
                        var id = json.category.id;
                        $("#messageDiv").html("分类id："+ id + "<br>分类名称:" +name );
                        
            });   
        });  
        </script>  
    </body>  
    
    </body>
    </html>
    ```  
    3.提交一条数据（submit.html）
    ```bash
    <!DOCTYPE html>
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
    <title>用AJAX以JSON方式提交数据</title>  
    <script type="text/javascript" src="jquery.min.js"></script>  
    </head>  
    <body>  
        <form >  
        id：<input type="text" id="id" value="123" /><br/>  
        名称：<input type="text" id="name" value="category xxx"/><br/>  
            <input type="button" value="提交" id="sender">   
        </form>  
        <div id="messageDiv"></div>  
        
        <script>  
        $('#sender').click(function(){  
            var id=document.getElementById('id').value;  
            var name=document.getElementById('name').value;  
            var category={"name":name,"id":id};  
            var jsonData = JSON.stringify(category);
            var page="submitCategory";  
            
            $.ajax({
                    type:"post",
                url: page,
                data:jsonData,
                dataType:"json",
                contentType : "application/json;charset=UTF-8",
                success: function(result){
                }
                });
            alert("提交成功，请在Tomcat控制台查看服务端接收到的数据");

        });
        </script>  
    </body>  
    
    </body>
    </html>
    ```
    - 获取一条数据  
    
    ![SSM-JSON测试1](https://image-1255440489.cos.ap-chengdu.myqcloud.com/SSMJSON%E6%B5%8B%E8%AF%951.jpg)
    - 获取全部数据  
      
    ![SSM-JSON测试2](https://image-1255440489.cos.ap-chengdu.myqcloud.com/SSMJSON%E6%B5%8B%E8%AF%952.jpg )
</font>  

# 五、[源码](https://github.com/lyj8330328/SSMDEMO)
