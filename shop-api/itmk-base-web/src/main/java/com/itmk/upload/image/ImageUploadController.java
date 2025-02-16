package com.itmk.upload.image;

import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class ImageUploadController {
    //图片上传到路径
    @Value("${web.uploadpath}")
    private String webUploadpath;

    @RequestMapping("/uploadImage")
    public ResultVo uploadImage(@RequestParam("file")MultipartFile file) {
        String Url="";
        //获取名称
        String fileName=file.getOriginalFilename();
        //获取拓展名
        String fileExtenionName=fileName.substring(fileName.indexOf("."));
        //生成新文件名
        String newName=UUID.randomUUID().toString()+fileExtenionName;
        //上传路径
        String path=webUploadpath;
        File fileDir=new File(path);

        if(!fileDir.exists()){
            //若地址不存在生成地址
            fileDir.mkdirs();
            //设置权限
            fileDir.setWritable(true);
        }
        File targetFile=new File(path,newName);
        try{
            //把file注进去
            file.transferTo(targetFile);
            //返回图片路径给前端
            Url="/"+targetFile.getName();
        }catch (Exception e){
            return null;
        }
        return ResultUtils.success("上传成功","/images"+Url);
    }
}
