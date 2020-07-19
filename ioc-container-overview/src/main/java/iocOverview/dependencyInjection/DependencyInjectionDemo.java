package iocOverview.dependencyInjection;

import iocOverview.dependencyLookup.UserConfig;
import iocOverview.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.applet.AppletContext;

public class DependencyInjectionDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserRepository.class, UserConfig.class);
        context.refresh();
        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        userRepository.printAllUser();
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getApplicationContextObjectFactory());
        System.out.println(userRepository.getObjectFactory().getObject());
        System.out.println(context == userRepository.getApplicationContextObjectFactory());
    }
}
