package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.Chapter;

import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/11/12
 */
public interface chapterDao {
    List<Chapter> selectChapter();
    List<Chapter> selectChapterById(int co_id);
    int insertChapter(Chapter chapter);
}
