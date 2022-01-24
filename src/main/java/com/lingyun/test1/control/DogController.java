package com.lingyun.test1.control;

import com.lingyun.test1.bean.Dog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName DogController
 * @Description TODO
 * @Author LingYun
 * @Date 2021/4/8 22:20
 * @Version
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class DogController {
    @Autowired
    @Qualifier("dog")
    private Dog mydog;

    @GetMapping("/getDog")
    public Dog getDogForComponent(){
        return mydog;
    }

    @GetMapping("/login")
    public Dog login(){
        return mydog;
    }
    @PostMapping("/upload")
    public void upload(@RequestPart("photos")MultipartFile[] photos,@RequestPart("photo")MultipartFile photo){
        log.info("photos.size={}",photos.length);
        if(photos.length>0){
            for(MultipartFile file:photos){
                try {
                    //文件夹原先需要存在
                    file.transferTo(new File("E:\\idea图片文件夹\\"+file.getOriginalFilename()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
