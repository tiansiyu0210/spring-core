package iocOverview.userRepository;

import iocOverview.dependencyLookup.UserConfig;
import iocOverview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    private final UserConfig userConfig;

    //inject build-in dependency
    private BeanFactory beanFactory;

    private ObjectFactory<List<User>> objectFactory;

    private ObjectFactory<ApplicationContext> applicationContextObjectFactory;

    public UserRepository(UserConfig userConfig, BeanFactory beanFactory, ObjectFactory<List<User>> objectFactory, ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
        this.userConfig = userConfig;
        this.beanFactory = beanFactory;
        this.objectFactory = objectFactory;
        this.applicationContextObjectFactory = applicationContextObjectFactory;
    }

    public UserConfig getUserConfig() {
        return userConfig;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<List<User>> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<List<User>> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public void printAllUser(){
        System.out.println(userConfig);
    }

    public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
        return applicationContextObjectFactory;
    }

    public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
        this.applicationContextObjectFactory = applicationContextObjectFactory;
    }
}
