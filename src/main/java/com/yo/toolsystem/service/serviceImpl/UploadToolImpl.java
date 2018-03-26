package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.TooluadMapper;
import com.yo.toolsystem.model.Tooluad;
import com.yo.toolsystem.service.UploadTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yoy on 2017/4/27.
 */
@Service
public class UploadToolImpl implements UploadTool {
    @Resource
    private TooluadMapper tooluadMapper;
//    public String getFileName(Part part) {
//        for (String content : part.getHeader("content-disposition").split(";")) {
//            if (content.trim().startsWith("filename")) {
//                return content.substring(
//                        content.indexOf('=') + 1).trim().replace("\"", "");
//            }
//        }
//        return null;
//    }

    public int insertToolRecord(Tooluad record) {
//        System.out.println(record.toString());
        return tooluadMapper.insertSelective(record);
    }


}
