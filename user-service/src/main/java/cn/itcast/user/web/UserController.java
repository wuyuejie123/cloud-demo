package cn.itcast.user.web;

import cn.itcast.user.config.PatternPropreties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope  //nacos 配置文件属性刷新
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;


//    @Value("${pattern.dateformat}")
//    private String dateformat;
    @Autowired
    private PatternPropreties patternPropreties;

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternPropreties.getDateformat()));
    }
    @GetMapping("prop")
    public PatternPropreties prop(){
        return patternPropreties;
    }
    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {

        return userService.queryById(id);
    }
}
