package iocOverview.containor;

import iocOverview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        //create BeanFactory container
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //load config
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //xml config classpath
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int countOfBean = reader.loadBeanDefinitions(location);
        System.out.println(countOfBean);
        lookupByCollectionType(beanFactory);
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookup collection: " + map);
        }
    }
}
