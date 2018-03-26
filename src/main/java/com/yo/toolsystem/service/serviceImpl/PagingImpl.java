package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.DownloadMapper;
import com.yo.toolsystem.dao.PersonMapper;
import com.yo.toolsystem.model.*;
import com.yo.toolsystem.service.ManagesPerson;
import com.yo.toolsystem.service.Paging;
import com.yo.toolsystem.service.SearchManager;
import com.yo.toolsystem.service.ToolManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoy on 2017/5/3.
 */
@Service
public class PagingImpl implements Paging{
    @Resource
    private ToolManager toolManager;
    @Resource
    private SearchManager searchManager;
    @Resource
    private DownloadMapper downloadMapper;
    @Resource
    private PersonMapper personMapper;
    @Resource
    private ManagesPerson managesPerson;

    public Pager<ToolsDisplay> getToolsPager(int currentPage,int pageSize) {
        Pager<ToolsDisplay> pager  = new Pager<ToolsDisplay>(currentPage,pageSize,toolManager.selectAllToolsNum());
//        int totalPage = pager.getTotalRecord()/pager.getPageSize();
        if (pager.getTotalRecord()==0){
            return pager;
        }
        List<ToolsDisplay>  toolsDisplays = toolManager.getDisplayTools(pager);
        System.out.println("size:::"+toolsDisplays.size());
        pager.setDataList(toolsDisplays);

        return pager;
    }

    public Pager<ToolsDisplay> getToolsPagerByType(int currentPage,int pageSize,int typeId){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
        Pager<ToolsDisplay> pager = new Pager<ToolsDisplay>(currentPage,pageSize,searchManager.searchByToolTypeIdNum(typeId));
        if (pager.getTotalRecord()==0){
            return pager;
        }
        List<Tooluad> tooluads = searchManager.searchByToolTypeId(typeId,pager);
        pager.setDataList(toolManager.getDisplayTools(tooluads));
        return pager;
    }


    public Pager<ToolsDisplay> searchTools(int currentPage, int pageSize, String words) {
        System.out.println("cu:"+currentPage+" ps:"+pageSize);
        Pager<ToolsDisplay> pager = new Pager<ToolsDisplay>(currentPage,pageSize,searchManager.searchToolsNum(words));
        System.out.println("from+"+pager.getFromIndex());
        List<Tooluad> tooluads = searchManager.searchTools(words,pager);
//        System.out.println("tooluads.size:"+tooluads.size());
        pager.setDataList(toolManager.getDisplayTools(tooluads));
        return pager;
    }

    public Pager getUnfinishedTools(int currentPage, int pageSize, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Person person = new Person();
        person = (Person) session.getAttribute("person");
        String userNum = person.getUsernum();
        Pager<ToolsDisplay> pager  = new Pager<ToolsDisplay>(currentPage,pageSize,downloadMapper.selectUnfinishedToolsNum(userNum));
        List<Download> downloads = downloadMapper.selectByUserNum(userNum);
        List<Tooluad> tooluads = new ArrayList<Tooluad>();
        for (Download download:downloads) {
            tooluads.add(toolManager.selectToolByPrimaryKey(download.getToolid()));
        }
        System.out.println("tooluads::"+tooluads.size());
        pager.setDataList(toolManager.getDisplayTools(tooluads));
        return pager;
    }

    public Pager getPeoplePager(int currentPage, int pageSize) {
        Pager<PersonDis> pager = new Pager<PersonDis>(currentPage,pageSize,personMapper.selectSubManagerNum());
        if (pager.getTotalRecord()==0){
            return pager;
        }
        List<Person> people = managesPerson.selectPeopleByPager(pager);
        List<PersonDis> peopleDis = managesPerson.getPeopleDis(people);
        System.out.println("peopleDis:"+peopleDis.size());
        pager.setDataList(peopleDis);
        return pager;
    }

    public Pager<PersonDis> getUsersPager(int currentPage, int pageSize) {
        Pager<PersonDis> pager = new Pager<PersonDis>(currentPage,pageSize,personMapper.selectUsersNum());
        if (pager.getTotalRecord()==0){
            return pager;
        }
        List<Person> people = managesPerson.selectUsersByPager(pager);
        List<PersonDis> peopleDis = managesPerson.getPeopleDis(people);
        System.out.println("peopleDis:"+peopleDis.size());
        pager.setDataList(peopleDis);
        return pager;
    }
}
