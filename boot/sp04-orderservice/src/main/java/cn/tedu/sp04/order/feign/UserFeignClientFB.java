package cn.tedu.sp04.order.feign;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFB implements UserFeignClient {
    @Override
    public JsonResult<User> getUser(Integer userId) {
        if (Math.random()<0.5){
            User user = new User(userId,"缓存用户" + userId , "缓存密码" +userId);
            return JsonResult.ok().data(user);
        }
        return JsonResult.err().msg("获取用户失败！！！");
    }

    @Override
    public JsonResult<?> addScore(Integer userId, Integer score) {


        return JsonResult.err().msg("用户积分增加失败！！！！");
    }
}
