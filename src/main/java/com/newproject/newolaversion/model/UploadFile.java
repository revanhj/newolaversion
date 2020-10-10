package com.newproject.newolaversion.model;

 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFile {
	
public static String UPLOAD="//home//madarsha//Desktop//K//";

	public <T> T upload(MultipartFile file){
		byte[] bytes = null;
		Map<String,String> map=new HashMap<>();
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOAD + file.getOriginalFilename());
        try {
			Files.write(path, bytes);
			map.put("status","1");
			return (T) (UPLOAD + file.getOriginalFilename());
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (T) "";
			
		}
        
		
	}

}