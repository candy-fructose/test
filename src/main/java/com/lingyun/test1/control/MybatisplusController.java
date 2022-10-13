package com.lingyun.test1.control;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingyun.test1.bean.User;
import com.lingyun.test1.dao.UserDao;
import com.lingyun.test1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName MybatisplusController
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/26 22:36
 * @Version
 */
@RestController
@RequestMapping("/mybatisplus")
@Slf4j
public class MybatisplusController {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @PostMapping("/insertUsers")
    public boolean insertUsers(List<User> userList) {
        boolean b = userService.saveBatch(userList);
        return b;
    }

    @GetMapping("/downloadByName/{keywords}")
    public void testExceptionHandler(@PathVariable String keywords, HttpServletResponse response) {
        List<User> users = userDao.selectList(new QueryWrapper<User>().like("name", keywords).or().like("card_no", keywords));
        if (!CollectionUtils.isEmpty(users)) {
            for (User user : users) {
                user.exGenderStr();
                user.exHobbyListName();
            }
        }
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        try {
            String fileName = new String("测试下载".getBytes(), StandardCharsets.ISO_8859_1);
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), User.class).sheet("模板").doWrite(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/selectByName/{keywords}/{page}")
    public List<User> selectByName(@PathVariable String keywords,@PathVariable("page")Integer pageNum) {
        pageNum = Optional.ofNullable(pageNum).orElse(0);
        List<User> records = userService.page(new Page<User>(pageNum, 2), new QueryWrapper<User>().like("name", keywords).or().like("card_no", keywords)).getRecords();
        if (!CollectionUtils.isEmpty(records)) {
            for (User user : records) {
                user.exGenderStr();
                user.exHobbyListName();
            }
        }
        return records;
    }
}
