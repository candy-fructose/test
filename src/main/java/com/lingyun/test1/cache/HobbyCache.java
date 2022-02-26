package com.lingyun.test1.cache;

import com.lingyun.test1.bean.HobbyInfo;
import com.lingyun.test1.dao.HobbyInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HobbyCache
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/28 21:27
 * @Version
 */
@Order(5)
@Component
public class HobbyCache implements CommandLineRunner {
    @Autowired
    HobbyInfoDao hobbyInfoDao;
    public static Map<String, String> hobbyMap = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        List<HobbyInfo> hobbyInfos = hobbyInfoDao.selectList(null);
        if (!CollectionUtils.isEmpty(hobbyInfos)) {
            for (HobbyInfo hobbyInfo : hobbyInfos) {
                hobbyMap.put(String.valueOf(hobbyInfo.getId()), hobbyInfo.getHobbyName());
            }
        }
    }
}
