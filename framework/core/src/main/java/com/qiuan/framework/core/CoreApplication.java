package com.qiuan.framework.core;

import com.qiuan.framework.core.config.CoreConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by qiuan on 2017/11/20.
 */
public class CoreApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoreConfig.class);

        context.close();
    }
}
