package iocOverview.dependencyInjection;

import iocOverview.dependencyLookup.UserConfig;
import iocOverview.userRepository.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

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

        //container build-in bean
        Environment environment1 = context.getBean(Environment.class);
        Environment environment2 = context.getEnvironment();
        System.out.println(environment1 == environment2);
        System.out.println("get Environment bean: " + environment1);
    }
}
