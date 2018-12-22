package com.springMvc.web;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file){//接收上传的文件
		try{
			//快速写入到磁盘中
			FileUtils.writeByteArrayToFile(new File("F:/test_upload_file/"+file.getOriginalFilename()), file.getBytes());
			return "ok";
		}catch(Exception e){
			return "wrong";
			
		}
	}
}
