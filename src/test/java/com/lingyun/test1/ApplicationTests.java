package com.lingyun.test1;

import com.lingyun.test1.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ApplicationTests {


    @Test
    void testGetMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        Long long1= null;
        Long long2=0L;
        System.out.println(long1+long2);
        System.out.println(">>>>>>>>" + hashMap.get(1));
    }

    //    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    RedisTemplate redisTemplate;
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Test
//    void contextLoads() {
//        List<User> users = jdbcTemplate.queryForList("select * from  user", User.class);
//        System.out.println(users.size());
//    }
//
//    @BeforeEach
//    void testBeforeEach() {
//        System.out.println("测试就要开始啦。。");
//    }
//
//    @AfterEach
//    void testAfterEach() {
//        System.out.println("测试结束啦。。");
//    }
//
//    @Test
//    void testRedis() {
//        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("hello", "world");
//        String hello = valueOperations.get("hello");
//        assertEquals("world", hello, "业务逻辑判断失败");
//        //如果前面断言失败，则之后的代码都不会执行
////        assertEquals("hello", hello, "业务逻辑判断失败");
//        //组合断言
////        assertAll("test", () -> assertTrue(true && true),
////                () -> assertEquals(1, 2));
//
//        System.out.println("=====");
//        //断言异常，有异常才是正常的
//        assertThrows(ArithmeticException.class,()->{
//            int i = 10/2;
//        });
//    }
    @Test
    void testCollection() {
        User user1 = new User();
        user1.setName("TOM1");
        user1.setAge(1);
        User user33 = new User();
        user33.setName("TOM33");
        user33.setAge(3);
        User user2 = new User();
        user2.setName("TOM2");
        user2.setAge(2);
        User user3 = new User();
        user3.setName("TOM3");
        user3.setAge(3);
        User user4 = new User();
        user4.setName("TOM22");
        user4.setAge(2);
        List<User> userList = new ArrayList<>();
        userList.add(user3);
        userList.add(user4);
        userList.add(user1);
        userList.add(user2);
        userList.add(user33);

        userList = userList.stream().sorted((s1, s2) -> -Long.compare(s1.getAge(), s2.getAge())).collect(Collectors.toList());
        List<Map.Entry<Integer, List<User>>> list = userList.stream()
                .collect(Collectors.groupingBy(User::getAge)).entrySet()
                .stream().sorted((s1, s2) -> -Long.compare(s1.getKey(), s2.getKey())).collect(Collectors.toList());
        System.out.println("userList:" + userList);
        Integer index = 1;

        for (Map.Entry<Integer, List<User>> entry : list) {
            for (User user : entry.getValue()) {
//                user.setRank(index);
            }

            // 100 100 99 98 98 97 对应名次 1 1 3 4 4 6
            index = index + entry.getValue().size();

            // 100 100 99 98 98 97 对应名次 1 1 2 3 3 4
            //  index = ++index;
        }
        System.out.println("userList:" + userList);

    }

}
