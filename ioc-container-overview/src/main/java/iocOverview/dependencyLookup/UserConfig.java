package iocOverview.dependencyLookup;

import iocOverview.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean("configUser")
    public User getUser(){
        User myUser = new User();
        myUser.setId(2L);
        myUser.setName("Siyu");
        return myUser;
    }

    @Bean("configUser1")
    public User getUser1(){
        User myUser = new User();
        myUser.setId(3L);
        myUser.setName("Siyu1");
        return myUser;
    }
}
