package com.ldg.wx.init;

import com.ldg.wx.utils.Access_token;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("BeanDefineConfigue")
public class InitWXToken implements ApplicationListener<ContextRefreshedEvent> {//ContextRefreshedEvent为初始化完毕事件，spring还有很多事件可以利用
/**
* 当一个ApplicationContext被初始化或刷新触发
*/
@Override
   public void onApplicationEvent(ContextRefreshedEvent event) {
       Access_token.init_Access_token();
   }
}