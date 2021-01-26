package utilTest;

import org.springframework.stereotype.Component;
import utilTest.annotion.MyLog;

/**
 *
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    @MyLog(name = "addUser" ,desc = "执行添加用户")
    public void addUser() {
        System.out.println("增加");
    }

    public void deleteUser() {
        System.out.println("删除");
    }

    public void updateUser() {
        System.out.println("更新");
    }

    public void findUser() {
        System.out.println("查询");
    }
}
