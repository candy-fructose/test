package com.lingyun.test1.service.serviceImpl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingyun.test1.bean.User;
import com.lingyun.test1.dao.UserDao;
import com.lingyun.test1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/28 10:55
 * @Version
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

    public void excelExport(List<User> list){
        String fileName = "E:\\测试临时文件\\" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, User.class).sheet("UserList").doWrite(list);
    }
}
