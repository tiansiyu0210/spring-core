package iocOverview.dependencyLookup;

import iocOverview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class DependencyLookupByBeanAnnotationDemo {
    public static void main(String[] args) {
        //我自己用@Bean annotation 试一试
        System.out.println("************ Bean Annotation ********************");
        scanDirectory();
        registryConfigAnnotation();
        lookupListOfBeans();
        getUserConfigBean();
    }

    private static void getUserConfigBean() {
        System.out.println("************ get USerConfig bean ********************");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserConfig.class);
        context.refresh();
        UserConfig userConfig = (UserConfig)context.getBean("userConfig");
        System.out.println(userConfig.getUser());
        System.out.println(userConfig.getUser1());
    }


    private static void lookupListOfBeans() {
        System.out.println("************ list of beans ********************");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserConfig.class);
        context.refresh();
        Map<String, User> map = context.getBeansOfType(User.class);
        System.out.println(map);
    }

    private static void scanDirectory() {
        System.out.println("************ context.scan ********************");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("iocOverview.dependencyLookup");
        context.refresh();
        User user = (User)context.getBean("configUser");
        System.out.println(user);
    }

    private static void registryConfigAnnotation(){
        System.out.println("************ context.register ********************");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserConfig.class);
        context.refresh();
        User user = context.getBean("configUser1", User.class);
        System.out.println(user);
    }
}
