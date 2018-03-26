package com.yo.toolsystem.controller;

import com.yo.toolsystem.dao.DownloadMapper;
import com.yo.toolsystem.model.DownloadKey;
import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.Tooluad;
import com.yo.toolsystem.service.*;
import com.yo.toolsystem.service.serviceImpl.DownloadFileBeanImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Yoy on 2017/4/24.
 */
@Controller
public class downloadToolController {
    @Resource
    private FileLength fileLength;
    @Resource
    private DownloadMapper downloadMapper;
    @Resource
    private ToolManager toolManager;
    @Resource
    DownloadManager downloadManager;
    @Resource
    private CommentsManager commentsManager;
    @Resource ManagesPerson managesPerson;
    @Resource
    ManagesCategory managesCategory;
    private Tooluad tooluad;

    @RequestMapping(value = "toolDetails/{toolID}", method = RequestMethod.GET)
    public String toolDetails(@PathVariable int toolID){
//        System.out.println(toolId);

        tooluad = toolManager.selectToolByPrimaryKey(toolID);
        return "redirect:/toolDetailPage";
    }

    @RequestMapping(value = "toolDetailPage", method = RequestMethod.GET)
    public String toolDetailPage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
//        int toolId = Integer.parseInt(request.getParameter("toolId"));
        model.addAttribute("comments",commentsManager.selectCommentsByToolId(tooluad.getId()));
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
        model.addAttribute("user",managesPerson.selectPersonByNum(tooluad.getPublisher()));
        model.addAttribute("tool",tooluad);
        return "toolDetail";
    }
    @RequestMapping(value = "downloadTool", method = RequestMethod.POST)
    public String download(HttpServletRequest request,Model model){
        int toolId = -1;
        int cont = 0;
        String toolPath;
        String filename;
        String c = request.getParameter("cont");
        if(c!=null){
            cont = Integer.parseInt(c);
        }
//        String path = "http://localhost:8080/"+request.getParameter("toolPath");
//        String filename = request.getParameter("filename");
//        path += "/"+filename;
//        String filename = "Git.rar";
//        String path = "http://localhost:8080/statics/img/Git.rar";
        HttpSession session = request.getSession();
//        System.out.println("----http://localhost:8080/statics/img/Git.rar---");
        System.out.println(request.getParameter("toolId"));
        if (request.getParameter("toolId")!=null){
//            System.out.println("NotNull");
            toolId = Integer.parseInt(request.getParameter("toolId"));
        }
        toolPath = toolManager.selectToolDirectory(toolId);
        String path = "http://localhost:8080/"+toolPath;
        filename = toolManager.selectToolName(toolId);
        path += "/"+filename;
//        System.out.println("toolId:---"+toolId+"---");
        Person user = (Person) session.getAttribute("person");
        if (cont==0){
            DownloadFileBeanImpl Task = new DownloadFileBeanImpl(toolManager);
            Task.setUsernum(user.getUsernum());
            Task.setToolid(toolId);
            Task.setPathserver(path);
            Task.setsSiteURL(path);
//            String downpath = "F:\\TestDownload";
            String downpath = request.getParameter("localPath");
            Task.setnStartPos(0);
            Task.setTargetPath(downpath);
            Task.setFilename(filename);
            Task.setLength(fileLength.getFileLength(path,"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36"));
            session.setAttribute("taskDownload", Task);
            new Thread(Task).start();
        }
        else{
            DownloadFileBeanImpl Task = new DownloadFileBeanImpl(toolManager);
            Task.setUsernum(user.getUsernum());
            Task.setToolid(toolId);
            Task.setDownloadMapper(downloadMapper);
            System.out.println("usernum:"+user.getUsernum());
            System.out.println("setToolId:"+toolId+"----");
//            System.out.println(path);
            Task.setPathserver(path);
            Task.setsSiteURL(path);
            String downpath = downloadManager.getPathClient(user.getUsernum(),toolId);
//            System.out.println("downpath:"+downpath);
            Task.setnStartPos(downloadMapper.selectByPrimaryKey(new DownloadKey(user.getUsernum(),toolId)).getStartpos());
            Task.setTargetPath(downpath);
            Task.setFilename(filename);
            Task.setLength(fileLength.getFileLength(path,"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36"));
            session.setAttribute("taskDownload", Task);
            new Thread(Task).start();
        }
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        return "status";
        return "downloading";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updateStatus(HttpServletRequest request,Model model){
        /**
         * 确保每一次刷新后还有id的值传到页面
         */
        HttpSession session = request.getSession();
        DownloadFileBeanImpl task = (DownloadFileBeanImpl) session.getAttribute("taskDownload");
        model.addAttribute("toolId",task.getToolid());
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        return "status";
        return "downloading";
    }

    @RequestMapping(value = "stopDownload", method = RequestMethod.POST)
    public String stopDown(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        DownloadFileBeanImpl task = (DownloadFileBeanImpl) session.getAttribute("taskDownload");
        task.setRunning(false,downloadMapper);
        model.addAttribute("toolId",task.getToolid());
        System.out.println("+++toolId+++:"+task.getToolid());
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        return "status";
        return "downloading";
    }
}
