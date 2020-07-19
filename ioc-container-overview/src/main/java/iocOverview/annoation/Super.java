package iocOverview.annoation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

//参考component的实现： org.springframework.stereotype.Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
