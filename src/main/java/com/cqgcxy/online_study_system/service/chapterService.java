package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.chapterDao;
import com.cqgcxy.online_study_system.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/11/12
 */
@Service
public class chapterService {

    @Autowired
    chapterDao chapterDao;
    //查询所有章节
    public List<Chapter> selectChapter(){
        return chapterDao.selectChapter();
    };
    //根据课程插入章节
    public int insertChapter(Chapter chapter){
        return chapterDao.insertChapter(chapter);
    };
}
