package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.UploadedFile;
import com.yo.toolsystem.service.ManagesCategory;
import com.yo.toolsystem.service.ToolManager;
import com.yo.toolsystem.service.UploadTool;
import com.yo.toolsystem.service.serviceImpl.TaskBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created by Yoy on 2017/4/24.
 */
@Controller
//@MultipartConfig
//@WebServlet
public class uploadToolController {
    @Resource
    private UploadTool uploadTool;
    @Resource
    private ManagesCategory managesCategory;
    @Resource
    private ToolManager toolManager;
    private String path;

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upLoad(Model model){
        model.addAttribute("toolCategorys",managesCategory.selectAllCategory());
        return "uploadTool";
    }

    @RequestMapping(value = "uploadT", method = RequestMethod.POST)
    public String uploadT(MultipartFile multipartFile, HttpServletRequest request,Model model){
//        System.out.println("----"+request.getParameter("category")+"----");
        HttpSession session = request.getSession();
        Person person = (Person)session.getAttribute("person");
//        try {
//            Part filePart = request.getPart("file");
//            String fileName = uploadTool.getFileName(filePart);
            String fileName = multipartFile.getOriginalFilename();

//            System.out.println("---"+fileName+"---");
            String version = request.getParameter("version");
            System.out.println("version"+version);
            String tags = request.getParameter("tags");
            String description = request.getParameter("description");
            String category = request.getParameter("category");
            String systemSupport = request.getParameter("systemSupport");
//            Integer Category = Integer.parseInt(category);
//            String publisher = person.getUsername()+"("+person.getUsernum()+")";
            String publisher = person.getUsernum();
//            path = "Uploads"+File.separator+category+File.separator+person.getUsernum()+File.separator+ fileName+File.separator+version;
            long now = System.currentTimeMillis();

//            path = "Uploads"+"/"+category+"/"+person.getUsernum()+"/"+ fileName+"/"+version;
            path = "Uploads"+"/"+category+"/"+ fileName+"/"+version+"_"+now;

//            String directory =  request.getSession().getServletContext().getRealPath("/")+File.separator+"Uploads"+File.separator+category+File.separator+person.getUsernum()+File.separator+ fileName+File.separator+version;
            String directory =  request.getSession().getServletContext().getRealPath("/")+File.separator+"Uploads"+File.separator+category+File.separator+ fileName+File.separator+version+"_"+now;

//            Tools tools = new Tools(fileName,Category,version,directory,publisher,description);
            UploadedFile uploadedFile = new UploadedFile(directory,fileName);
            uploadedFile.setCategory(category);
            uploadedFile.setDescription(description);
            uploadedFile.setPublisher(publisher);
            uploadedFile.setVersion(version);
            uploadedFile.setTags(tags);
            uploadedFile.setSystemSupport(systemSupport);
            TaskBean task = new TaskBean(multipartFile, uploadedFile, uploadTool, toolManager,path);
            new Thread(task).start();
            session.setAttribute("task", task);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
        return "status2";
    }

//    @RequestMapping(value = "uploadT", method = RequestMethod.POST)
//    public String uploadT(HttpServletRequest request) throws IOException {
//        /**
//         * 从request中获取流信息
//         */
//        InputStream fileSource = request.getInputStream();
//        String tempFileName = request.getSession().getServletContext().getRealPath("/")+File.separator+"tempFile";
//
//        /**
//         * tempFile指向临时文件
//         */
//        File tempFile= new File(tempFileName);
//
//        /**
//         * outputStream文件输出流指向这个临时文件
//         */
//        FileOutputStream outputStream = new FileOutputStream(tempFile);
//        byte b[] = new byte[1024];
//        int n;
//        while((n = fileSource.read(b))!=-1){
//            outputStream.write(b, 0, n);
//        }
//
//        /**
//         * 关闭输出流、输入流
//         */
//        outputStream.close();
//        fileSource.close();
//
//        /**
//         * 获取上传文件的名称
//         */
//        RandomAccessFile randomFile = new RandomAccessFile(tempFile,"r");
//        randomFile.readLine();
//        String str = randomFile.readLine();
//        int beginIndex = str.lastIndexOf("\\")+1;
//        int endIndex = str.lastIndexOf("\"");
//        String fileName = str.substring(beginIndex,endIndex);
////        System.out.println("filename:"+filename);
//
//        /**
//         * 重新定位文件指针到文件头
//         */
//        randomFile.seek(0);
//        long startPosition = 0;
//        int i = 1;
//        int offset=0;
//        /**
//         * 获取文件内容开始位置
//         */
//        while((n=randomFile.readByte())!=-1&&i<=4){
//            offset++;
//            if(n == '\n'){
//                startPosition = randomFile.getFilePointer();
//                i++;
//            }
//        }
//        //	startPosition--;
//        /**
//         * 获取文件内容结束位置
//         */
//        randomFile.seek(randomFile.length());
//        long endPosition = randomFile.getFilePointer();
//        int j=1;
//        while(endPosition>=0&&j<=2){
//            endPosition--;
//            randomFile.seek(endPosition);
//            if(randomFile.readByte()=='\n'){
//                j++;
//            }
//        }
//        endPosition--;
//
//        HttpSession session = request.getSession();
//        Person person = (Person)session.getAttribute("person");
////        System.out.println("---"+fileName+"---");
//        String version = request.getParameter("version");
//        System.out.println("version"+version);
//        String description = request.getParameter("description");
//        String category = request.getParameter("category");
//        String publisher = person.getUsernum();
//        path = "Uploads"+File.separator+category+File.separator+person.getUsernum()+File.separator+ fileName+File.separator+version;
//        String directory =  request.getSession().getServletContext().getRealPath("/")+File.separator+"Uploads"+File.separator+category+File.separator+person.getUsernum()+File.separator+ fileName+File.separator+version;
//        UploadedFile uploadedFile = new UploadedFile(directory,fileName);
//        uploadedFile.setCategory(category);
//        uploadedFile.setDescription(description);
//        uploadedFile.setPublisher(publisher);
//        uploadedFile.setVersion(version);
//        File saveFile = new File(directory,fileName);
//        RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
//
//        TaskBean task = new TaskBean(randomFile, uploadedFile, uploadTool, toolManager,path);
//        new Thread(task).start();
//        session.setAttribute("task", task);
////        } catch (IOException e) {
////            e.printStackTrace();
////        } catch (ServletException e) {
////            e.printStackTrace();
////        }
//        return "status2";
//    }
    @RequestMapping(value = "updateU", method = RequestMethod.GET)
    public String updateU(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        TaskBean taskBean = (TaskBean) session.getAttribute("task");
        if(taskBean.getPercentage()==100){
            return "redirect:toolsDisplay";
        }
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
        return "status2";
    }

    @RequestMapping(value = "stopUpload", method = RequestMethod.GET)
    public String stopUpload(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        TaskBean task = (TaskBean) session.getAttribute("task");
        task.setRunning(false);
        if (task!=null){
            UploadedFile file = task.getFile();
            File directoryToBeDeleted = new File(file.getDirectory());
            request.setAttribute("directoryToBeDeleted", new File(file.getDirectory()));
            System.out.println("file.getDirectory():"+file.getDirectory());
            model.addAttribute("toolTypes",managesCategory.selectAllCategory());
            if(directoryToBeDeleted!=null){
                System.out.println("---1---");
                toolManager.deleteFile(new File(file.getDirectory()));
//                return "toolDisplay";
                return "redirect:/toolsDisplay";
            }else {
                request.getSession().removeAttribute("task");
                return "redirect:/toolsDisplay";
//                return "toolDisplay";
            }
        }
        else {
            return "redirect:/toolsDisplay";
//            return "toolDisplay";
        }
    }

//    @RequestMapping(value = "uploadT/updateDB", method = RequestMethod.POST)
//    public String updateDB(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        TaskBean task = (TaskBean) session.getAttribute("task");
//        if (task!=null){
//            UploadedFile file = task.getFile();
//            File directoryToBeDeleted = new File(file.getDirectory());
//            if (task.isCompleted()){
//                try {
//                int r;
//                Tools tools = new Tools();
//                tools.setName(file.getName());
//                tools.setDirectory(file.getDirectory());
//                tools.setCategory(Integer.parseInt(file.getCategory()));
//                tools.setPublisher(file.getPublisher());
//                tools.setDescription(file.getDescription());
//                r = uploadTool.insertToolRecord(tools);
//                if (r>0){
//                        new PrintWriter(new File(file.getDirectory()+"/comments.txt"));
//                        return "reports";
//                }else {
//                    if(directoryToBeDeleted!=null){
//                        toolManager.deleteFile(new File(file.getDirectory()));
//                        return "reports";
//                    }else {
//                        request.getSession().removeAttribute("task");
//                        return "toolDisplay";
//                    }
//                }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    session.removeAttribute("task");
//                    if(directoryToBeDeleted!=null){
//                        toolManager.deleteFile(new File(file.getDirectory()));
//                        return "reports";
//                    }else {
//                        request.getSession().removeAttribute("task");
//                        return "toolDisplay";
//                    }
//                }
//            }
//        }
//        return "toolDisplay";
//    }
}
