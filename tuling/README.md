## 编译环境
```markdown
- gradle 版本小于7.x即可，否则 build.gradle 编译的指令不相同，需要去修改build.gradle的编译指令
    - 下载地址：https://mirrors.cloud.tencent.com/gradle/
- jdk 1.8
```

## 源码部分

```markdown

AnnotationConfigApplicationContext
    - AnnotatedBeanDefinitionReader 
    - ClassPathBeanDefinitionScanner

```

## Bean的声明周期

```markdown
1、doScan：扫描并生成BeanDefinition
    - 扫描classpath 的.class封装为Resource
    - 获取Resource 的MetadataReader
        - MetadataReader（类的元数据读取器）
        - ScannedGenericBeanDefinition
    - 根据MetadataReader 进行excludeFilters和includeFilters、@Conditional筛选
    - 判断是否是对应的类、非接口和抽象类
    - 扫描到的是一个bean，加入到 beanDefinitionMap 结果集

```

