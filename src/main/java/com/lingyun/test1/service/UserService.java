package com.lingyun.test1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingyun.test1.bean.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/28 10:54
 * @Version
 */
public interface UserService extends IService<User> {
    void excelExport(List<User> list);
}
