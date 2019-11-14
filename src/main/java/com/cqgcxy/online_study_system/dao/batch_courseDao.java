package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.Batch_course;

import java.util.List;

public interface batch_courseDao {
    int insertBatchCourse(List<Batch_course> batch_course);
    int deleteBatchCourse(int batch_id);
}
