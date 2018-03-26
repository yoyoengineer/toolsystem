package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.TooluadMapper;
import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.ToolsDisplay;
import com.yo.toolsystem.model.Tooluad;
import com.yo.toolsystem.service.SearchManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yoy on 2017/4/29.
 */
@Service
//@Scope("prototype")
public class SearchManagerImpl implements SearchManager {
    @Resource
    private TooluadMapper tooluadMapper;
    private List<Tooluad> tooluads = new ArrayList<Tooluad>();
    public List<String> separatesWords(String source) {
        String[] words = source.split(" ");
        List<String> results = new ArrayList<String>();
        for (int i =0;i<words.length;i++){
            results.add(words[i]);
        }
        return results;
    }

//    public List<Tooluad> searchByName(List<String> source) {
    public List<Tooluad> searchByName(String toolName){
        List<Tooluad> tooluads1 = new ArrayList<Tooluad>();
//        for (String toolName: source){
            toolName = "%"+toolName+"%";
            tooluads1 = tooluadMapper.selectByName(toolName);
            for (Tooluad tooluad:tooluads1){
                tooluads.add(tooluad);
            }
//        }
        return tooluads1;
    }

//    public List<Tooluad> searchByDescription(List<String> source) {
    public List<Tooluad> searchByDescription(String description){
        List<Tooluad> tooluads1 = null;
//        for (String description: source){
            description = "%"+description+"%";
            tooluads1 = tooluadMapper.selectByDescription(description);
            for (Tooluad tooluad:tooluads1){
                tooluads.add(tooluad);
            }
//        }
        return tooluads1;
    }

//    public List<Tooluad> searchByTags(List<String> source){
    public List<Tooluad> searchByTags(String tag){
        List<Tooluad> tooluads1 = null;
//        for (String tags: source){
            tag = "%"+tag+"%";
            tooluads1 = tooluadMapper.selectByTag(tag);
            for (Tooluad tooluad:tooluads1){
                tooluads.add(tooluad);
            }
//        }
        return tooluads1;
    }

//    public List<Tooluad> searchByPubilsher(List<String> source) {
    public List<Tooluad> searchByPubilsher(String pubilsher){
        List<Tooluad> tooluads1 = null;
//        for (String pubilsher: source){
            pubilsher = "%"+pubilsher+"%";
            tooluads1 = tooluadMapper.selectByPubilsher(pubilsher);
            for (Tooluad tooluad:tooluads1){
                tooluads.add(tooluad);
//            }
        }
        return tooluads1;
    }

    public List<Tooluad> searchByToolTypeId(int typeId, Pager<ToolsDisplay> pager){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start",pager.getFromIndex());
        map.put("size",pager.getPageSize());
        map.put("typeId",typeId);
        List<Tooluad> tooluads1 = null;
        tooluads1 = tooluadMapper.selectByToolTypeId(map);
        for (Tooluad tooluad:tooluads1){
            tooluads.add(tooluad);
        }
        return tooluads1;
    }

    public List<Tooluad> searchTools(String source){
        List<String> words = this.separatesWords(source);
        for (String word:words){
            this.searchByDescription(word);
            this.searchByName(word);
            this.searchByPubilsher(word);
        }
        return tooluads;
    }

    public int searchByToolTypeIdNum(int typeId) {
        return tooluadMapper.selectByToolTypeIdNum(typeId);
    }

    public int searchToolsNum(String source) {
        List<String> words = this.separatesWords(source);
        int totalRecords=0;
        for (String word:words){
            word = "%"+word+"%";
            totalRecords+=tooluadMapper.selectToolsNumBySearch(word);
        }
        System.out.println("totalRecords:"+totalRecords);
        return totalRecords;
    }

    public List<Tooluad> searchTools(String source, Pager<ToolsDisplay> pager) {
        List<Tooluad> tooluads1 = new ArrayList<Tooluad>();
        List<String> words = this.separatesWords(source);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start",pager.getFromIndex());
        map.put("size",pager.getPageSize());
        for (String word:words){
            word = "%"+word+"%";
            map.put("word",word);
            System.out.println(word);
            System.out.println(pager.getFromIndex());
            System.out.println(pager.getPageSize());
            tooluads1 = tooluadMapper.searchTools(map);
        }
        return tooluads1;
    }
}
