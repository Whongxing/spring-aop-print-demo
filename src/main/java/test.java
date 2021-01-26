import utilTest.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class test {

    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("MATE-INF/applicationProperties.xml");
        String[] beanName = beanFactory.getBeanDefinitionNames();
        for(String s : beanName){
            System.out.println(s);
        }
        UserService user = (UserService) beanFactory.getBean("userService");
        System.out.println("********************************************");
        user.addUser();
        user.deleteUser();
        user.updateUser();
        user.findUser();
    }
}

