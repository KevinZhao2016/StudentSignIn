package com.dao;

import com.model.PresenceEntity;

import java.util.List;

/**
 * Created by Gavin on 2018/7/10.
 */
public interface DataStatisticsDao {

//    List In_Out_Students(String TUserName, int CID, int state);   //列出到课学生信息和列出缺课学生信息

    List Miss_rate_Attendance(String CName, int Cno);    //缺课率和到课率
    List SingleClass(String CName, int Cno, int state);    //列出单次到课与缺课学生信息
    List AllClass(String CName, int state);     //列出一门课程所有到课与迟到学生信息
//    List AllClass(String CName);     //列出一门课程一学期的学生签到情况
}
