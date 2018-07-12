package com.server;

import java.util.List;

/**
 * Created by Gavin on 2018/7/10.
 */
public interface DataStatisticsServer {
//    List GetStudentInformation(String TUserName, int CID, int state);

    List GetCount(String CName, int Cno);       //列出按时、迟到、未到人数。
    List SingleStudentInformaiton(String CName, int Cno, int state);    //列出签到表中相应课程、周数、状态的学生信息
    List AllStudentInformation(String CName, int state);     //列出签到表中相应课程的所有签到状态
//    List AllStudentState(String CName);     //列出一门课程一学期的学生签到情况
}
