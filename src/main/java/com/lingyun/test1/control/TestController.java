package com.lingyun.test1.control;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lingyun.test1.bean.Car;
import com.lingyun.test1.bean.Pet;
import com.lingyun.test1.bean.User;
import com.lingyun.test1.dao.UserDao;
import com.lingyun.test1.exception.MyException;
import com.lingyun.test1.service.UserService;
import com.lingyun.test1.tool.UserExcelWriteListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author LingYun
 * @Date 2021/4/28 22:10
 * @Version
 */
@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {
    @Autowired
    Car mycar;
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    StringRedisTemplate redisTemplate;//注意StringRedisTemplate与RedisTemplate的数据是不互通的，序列化策略也不同。
    // RedisTemplate采用JDK的序列化策略，StringRedisTemplate采用String的序列化策略

    @GetMapping("/testExceptionHandler")
    public void testExceptionHandler() {
        System.out.println("hello123");
        int i = 10 / 0;
    }

    @GetMapping("/test")
    public void test() {
        Car car = new Car(new User(new Pet(2)));
        System.out.println(car);
    }

    @GetMapping("/testMyExceptionHandler")
    public void testMyExceptionHandler() {
        throw new MyException();
    }

    @GetMapping("/login")
    public int test1() {
//        List<User> users = userDao.selectList(null);
//
//        List<String> list =null;
//        for(String str:list){//报错
//            System.out.println(str);
//        }
//        System.out.println("hello");
        return Runtime.getRuntime().availableProcessors();
    }

    @GetMapping("/show")
    public String test2() {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        String o = valueOperations.get("/test/login");
        return o;
    }


    //通过easyexcel下载excel文件
    @GetMapping("/excelExport/{keywords}")
    public void excelExport(@PathVariable String keywords) {
        List<User> users = userDao.selectList(new QueryWrapper<User>().like("name", keywords).or().like("card_no", keywords));
        if(!CollectionUtils.isEmpty(users)){
            for(User user:users){
                user.exGenderStr();
                user.exHobbyListName();
            }
        }
        userService.excelExport(users);
    }

    //文件上传
    @PostMapping("/upload")
    public void export(@RequestPart("excels") MultipartFile[] excels) {
        if (excels.length > 0) {
            for (MultipartFile excel : excels) {
                if (excel.isEmpty()) {
                    continue;
                }
                String fileName = "F:\\文件上传\\" + excel.getOriginalFilename();
                // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
                try {
                    EasyExcel.read(excel.getInputStream(), User.class, new UserExcelWriteListener(userService)).sheet().doRead();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                //保存到文件服务器
//                try {
//                    excel.transferTo(new File(fileName));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }


}
