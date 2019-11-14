package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.Batch;
import com.cqgcxy.online_study_system.entity.Course;
import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.service.batchService;
import com.cqgcxy.online_study_system.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class batchConterllor {

    @Autowired
    batchService batchService;
    @Autowired
    courseService courseService;

    /**
     * 批次列表
     * @return
     */
    @RequestMapping("/bacthList")
    public ModelAndView bacthList(){
        List<Batch> list = batchService.selectBatch();
        ModelAndView view = new ModelAndView("/management/batch/batchList");
        view.addObject("batch",list);
        return view;
    }

    /**
     * 批次添加页面
     * @return
     */
    @RequestMapping("/batchAdd")
    public ModelAndView batchAdd(){
        ModelAndView view = new ModelAndView("/management/batch/batchAdd");
        List<Course> courses = courseService.selectCourse();
        view.addObject("courses",courses);
        return view;
    }

    /**
     * 批次修改页面
     * @param batch_id
     * @return
     */
    @RequestMapping("/batchById")
    public ModelAndView roleById(@RequestParam("batch_id")String batch_id){
        ModelAndView view = new ModelAndView("/management/batch/BatchEdit");
        List<Course> courses = courseService.selectCourse();
        Batch batch =batchService.selectBatchById(Integer.parseInt(batch_id));
        view.addObject("batch",batch);
        view.addObject("courses",courses);
        return view;
    }

    /**
     * 批次添加提交
     * @param role_name
     * @param per
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/roleAdd_submit")
//    public ResultMsg roleAdd_submit(@RequestParam("begintime") String begintime,
//                                    @RequestParam("endtime") String endtime,
//                                    @RequestParam("per") String per []){
//        Batch  batch = new Batch();
//        try {
//            batch.setBegintime();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        int i = roleService.insetRole(role,per);
//        if (i==1){
//            return new ResultMsg(1,"成功");
//        }else {
//            return new ResultMsg(0,"失败");
//        }
//    }
//
//    /**
//     * 角色修改提交
//     * @param role_id
//     * @param role_name
//     * @param per
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("/roleAdd_Edit")
//    public ResultMsg roleAdd_Edit(  @RequestParam("role_id") String role_id,
//                                    @RequestParam("role_name") String role_name,
//                                    @RequestParam("per") String per []){
//        Role role = new Role();
//        role.setRole_id(Integer.parseInt(role_id));
//        role.setRole_name(role_name);
//
//        int i = roleService.updateRolrAdmin(role,per);
//        if (i==1){
//            return new ResultMsg(1,"成功");
//        }else {
//            return new ResultMsg(0,"失败");
//        }
//    }

}
