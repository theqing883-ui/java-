package testxxq;

import com.minispring.context.ApplicationContext;
import com.minispring.context.support.ClassPathXmlApplicationContext;
import com.minispring.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class BeanTest {
    @Test
    public void getBeanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beansxxq.xml");

        UserService userService = (UserService) context.getBean("userService");
//        userService.setName("张三");
        System.out.println(userService.queryUserInfo());
    }
}
