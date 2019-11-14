package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.Batch;

import java.util.List;

public interface batchDao {
    List<Batch> selectBatch();
    int insertBatch(Batch batch);
    int updateBatch(Batch batch);
    Batch selectBatchById(int batch_id);
}
