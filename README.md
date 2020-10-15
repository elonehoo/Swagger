# Swagger 的食用教程

###  技术

**语言 :  [Java](https://www.java.com/zh-CN/)**

**框架 : [SpringBoot](https://spring.io/) + [Swagger](https://swagger.io/)**

**工具 : [Maven](https://mvnrepository.com) + [IDEA](https://www.jetbrains.com/)  + [PostMan](https://www.postman.com/) + [Swagger](https://swagger.io/)**



### 说明

```markdown
# 丝袜哥 `Swagger` 是研发的好帮手,可以减少很多后端和前端的沟通的成本,甚至在很多高级的公司,还能够减少后端和测试人员的沟通成本.所以只需要一个项目采用了SpringBoot框架,丝袜哥 `Swagger` 几乎就是必须要选择的组件
# 在之前 Swagger的工具的starter是百花齐放,而现在,终于有了官方的启动工具类,接下来就是快速食用工具
```



### pom依赖

```xml
<!--导入 丝袜哥 (Swagger)-->
<dependency>
<groupId>io.springfox</groupId>
	<artifactId>springfox-boot-starter</artifactId>
	<version>3.0.0</version>
</dependency>
<!--配置jar包-->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-oas</artifactId>
	<version>3.0.0</version>
</dependency>
```



### 浏览器访问地址

```url
http://localhost:8181/springboot-swagger/swagger-ui/
```

**有网址说需要添加 `@EnableOpenApi` 注解,但其实是不需要的**

![接口文档的首页截图](https://ss.im5i.com/2020/10/15/Snipaste_2020-10-15_20-40-43.png)



### 关于整合认证(权限)插件

#### 如果用到了`Spring Security` 权限的控制组件,记得要加入白名单

```java
//例如
String[] SWAGGER_WHITELIST = {
        "/swagger-ui.html",
        "/swagger-ui/*",
        "/swagger-resources/**",
        "/v2/api-docs",
        "/v3/api-docs",
        "/webjars/**"
};
httpSecurity.cors()
        .antMatchers(SWAGGER_WHITELIST).permitAll();
```



### 但是在某些时候,我们使用了 JWT 这样的中间件 , 就需要在请求接口的时候,在 `Header` 中构造一个token,Swagger 也支持了他们



```java
//基础的配置

/**
 * SwaggerConfig
 * Swagger 的实体类
 * @author HCY
 * @since 2020/10/15
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //开启个人信息
                .apiInfo(apiInfo())
                .select()
                .build()
                //每一个请求都可以添加header
                .globalRequestParameters(globalRequestParameters())
            	//开启全局的token
                .securitySchemes(security());

    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api文本
                .title("晓寻遥 api")
                //说明
                .description("更多请咨询晓寻遥")
                //用户名 + 网址 + 邮箱
                .contact(new Contact("晓寻遥" ,
                        "https://github.com/xiaoxunyao" ,
                        "2414776185@qq.com"))
                //版本
                .version("1.0")
                //运行
                .build();
    }
}
```



#### 第一种,通过全局的Auth认证方式

```java
private List<SecurityScheme> security() {
        ApiKey apiKey = new ApiKey("Token", "Token", "header");
        return Collections.singletonList(apiKey);
}
```

![全局token请求](https://ss.im5i.com/2020/10/15/Snipaste_2020-10-15_20-51-11.png)

#### 第二种, 每个请求一个token , 适用于 快速过期的JWT模式

```java
private List<RequestParameter> globalRequestParameters() {
        RequestParameterBuilder parameterBuilder = new RequestParameterBuilder()
                //每次请求加载header
                .in(ParameterType.HEADER)
                //头标签
                .name("Token")
                .required(false)
                .query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));
        return Collections.singletonList(parameterBuilder.build());
}
```

![每个请求都带上token](https://ss.im5i.com/2020/10/15/Snipaste_2020-10-15_20-53-18.png)



# 结束

```markdown
# 不用自己写接口文档了,让前端的小伙伴看了一下 丝袜哥 `Swagger` ,小伙伴说再也不想看我写的接口文档了,我就明白了,用它用它.
# nice
```
