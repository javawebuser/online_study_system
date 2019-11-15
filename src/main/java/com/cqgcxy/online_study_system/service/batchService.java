package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.batchDao;
import com.cqgcxy.online_study_system.dao.batch_courseDao;
import com.cqgcxy.online_study_system.entity.Batch;
import com.cqgcxy.online_study_system.entity.Batch_course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Service
public class batchService {

    @Autowired
    batchDao batchDao;
    @Autowired
    batch_courseDao batch_courseDao;

    //批次列表
    public List<Batch> selectBatch(){
        return batchDao.selectBatch();
    };
    //添加批次
    @Transactional
    public int insertBatch(Batch batch,String per []){
        //添加批次、批次添加失败返回0
        int i = batchDao.insertBatch(batch);
        List<Batch_course> list=new ArrayList<>();
        if (i==1){
            for (int j=0;j<per.length;j++){
                //将添加批次后的batch_id，写到Role_permission中
                Batch_course course = new Batch_course();
                course.setBatch_id(batch.getBatch_id());
                course.setCo_id(Integer.parseInt(per[j]));
                list.add(course);
            }
            int k = batch_courseDao.insertBatchCourse(list);
            //判断添加条数是否正确，正确放回1，错误回滚事务，并放回0
            if (k==per.length){
                return 1;
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }else{
            return 0;
        }
    };
    //修改批次
    @Transactional
    public int updateBatch(Batch batch,String per []){
        //1.修改批次，修改失败返会0
        int i = batchDao.updateBatch(batch);
        List<Batch_course> list=new ArrayList<>();
        if (i==1){
            //2.删除批次所有课程，删除失败回滚事务，返回0
            int j = batch_courseDao.deleteBatchCourse(batch.getBatch_id());
            if (j>0){
                for (int l=0;l<per.length;l++){
                    //将添加批次后的batch_id，写到Role_permission中
                    Batch_course course = new Batch_course();
                    course.setBatch_id(batch.getBatch_id());
                    course.setCo_id(Integer.parseInt(per[l]));
                    list.add(course);
                }
                //判断添加条数是否正确，正确放回1，错误回滚事务，并放回0
                int m = batch_courseDao.insertBatchCourse(list);
                if (m==per.length){
                    return 1;
                }else {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }else{
            return 0;
        }
    };

    public Batch selectBatchById(int batch_id) {
        return batchDao.selectBatchById(batch_id);
    }
}
