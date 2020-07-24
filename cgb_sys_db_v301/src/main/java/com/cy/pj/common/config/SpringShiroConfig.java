package com.cy.pj.common.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**@Configuration 注解描述的类为一个配置对象,
 * 此对象也会交给spring管理
 */
@Configuration
public class SpringShiroConfig {//srping-shiro.xml

    /**
     * SecurityManager 对象shiro框架的核心
     * @Bean 通常会配置@Configuration注解进行使用，其他特点：
     * 1）此注解描述方法会交给spring管理
     * 2)@注解没有指定其value属性的值，则bean的名字默认为方法名
     * @return
     */
    @Bean
    public SecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager sManager=
                new DefaultWebSecurityManager();
        sManager.setRealm(realm);
        return sManager;
    }


    /**
     * Spring容器在管理ShiroFilterFactoryBean对象，会基于ShiroFilterFactoryBean
     * 创建过滤工厂对象（ShiroFilter），然后通过过滤器工厂创建过滤器（filter）对象，最后通过filter对请求数据进行过滤
     * 例如调用securityManager的方法判定此请求是否已经过认证，假如没有经过认证，
     * 则跳转到登录页面进行认证即可
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Autowired SecurityManager securityManager){
        ShiroFilterFactoryBean sfBean= new ShiroFilterFactoryBean();
        sfBean.setSecurityManager(securityManager);
        //设置需要进行认证的登录页面
        sfBean.setLoginUrl("/doLoginUI");
        //定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问，有顺序，匿名的放上面)
        LinkedHashMap<String,String> map=new LinkedHashMap<>();
        //静态资源允许匿名访问:"anon"
        map.put("/bower_components/**","anon");
        map.put("/build/**","anon");
        map.put("/dist/**","anon");
        map.put("/plugins/**","anon");
        map.put("/user/doLogin","anon");
        //除了匿名访问的资源,其它都要认证("authc")后访问
        map.put("/**","authc");
        sfBean.setFilterChainDefinitionMap(map);
        return sfBean;
    }
}
