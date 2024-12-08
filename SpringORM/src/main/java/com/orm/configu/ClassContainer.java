package com.orm.configu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.orm.entity,com.tap.daofile")
public class ClassContainer {

}
