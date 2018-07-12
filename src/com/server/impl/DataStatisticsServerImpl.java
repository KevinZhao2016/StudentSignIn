package com.server.impl;

import com.dao.DataStatisticsDao;
import com.dao.StudentDao;
import com.dao.impl.DataStatisticsDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.model.PresenceEntity;
import com.model.StudentEntity;
import com.server.DataStatisticsServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin on 2018/7/10.
 */
public class DataStatisticsServerImpl implements DataStatisticsServer{
    DataStatisticsDao dataStatisticsDao = new DataStatisticsDaoImpl();
    StudentDao studentDao = new StudentDaoImpl();
//    @Override
//    public List GetStudentInformation(String TUserName, int CID, int state){
//        List list = dataStatisticsDao.In_Out_Students(TUserName, CID, state);
//        List list_student_inf = new ArrayList();
//        for(int i = 0; i < list.size(); i++){
//            String sno = String.valueOf(list.get(i));
//            list_student_inf.add(studentDao.findStudentByID(sno));
//        }
//        return list_student_inf;
//    }

    @Override
    public List GetCount(String CName, int Cno){
        int comeInTime = 0;     //按时到人数
        int comeLate = 0;       //迟到人数
        int totalNumber = 0;     //总人数
        List list = dataStatisticsDao.Miss_rate_Attendance(CName, Cno);
        for(int i = 0; i < list.size(); i++){
            PresenceEntity a = (PresenceEntity) list.get(i);
            if(a.getState() == 1){
                comeInTime = comeInTime + 1;
            }else {
                comeLate = comeLate + 1;
            }
        }
        StudentDao studentDao = new StudentDaoImpl();
        List list1 = studentDao.ListStudent();
        totalNumber = list1.size();
        List rate = new ArrayList();
        rate.add(0, comeInTime);    //按时到人数
        rate.add(1, comeLate);      //迟到人数
        rate.add(2, totalNumber - (comeInTime + comeLate));     //未到人数
        rate.add(3, totalNumber);       //总人数
        return rate;
    }

    @Override
    public List SingleStudentInformaiton(String CName, int Cno, int state){
        List list = dataStatisticsDao.SingleClass(CName, Cno, state);
        List listStudentInformation = new ArrayList();
        if(state == 0 || state == 1) {
            for (int i = 0; i < list.size(); i++) {
                PresenceEntity a = (PresenceEntity) list.get(i);
                String sno = String.valueOf(a.getSno());
                listStudentInformation.add(studentDao.findStudentByID(sno));
            }
            listStudentInformation.add(list);
        }else {
            StudentDao studentDao = new StudentDaoImpl();
            List list1 = studentDao.ListStudent();
            List snoAll = new ArrayList();
            for(int i = 0; i < list1.size(); i++){
                StudentEntity a = (StudentEntity) list1.get(i);
                String sno = String.valueOf(a.getSno());
                snoAll.add(sno);
            }
            List sno = new ArrayList();
            for(int i = 0; i < list.size(); i++){
                PresenceEntity a = (PresenceEntity) list.get(i);
                String snos = String.valueOf(a.getSno());
                sno.add(snos);
            }
            for(int i = 0; i < snoAll.size(); i++){
                if (!sno.contains(snoAll.get(i))){
                    String sno1 = String.valueOf(snoAll.get(i));
                    listStudentInformation.add(studentDao.findStudentByID(sno1));
                }
            }
        }
        return listStudentInformation;
    }

//    @Override
//    public List AllStudentState(String CName){
//        List list = dataStatisticsDao.AllClass(CName);
//        List listAllInformation = new ArrayList();
//        List listAllSno = new ArrayList();
//        int[][] count = new int[10000000][1];
//        for(int i = 0; i < list.size(); i++){
//            List list1 = (List)list.get(i);
//            for(int j = 0; j < list1.size(); j++){
//                PresenceEntity a = (PresenceEntity) list1.get(j);
//                if (!listAllSno.contains(list1.get(j)) && a.getState() == 1){
//                    listAllSno.add(list1.get(j));
//                    count[a.getState()][0] = 1;
//                }else if (!listAllSno.contains(list1.get(j)) && a.getState() == 0){
//                    listAllSno.add(list1.get(j));
//                    count[a.getState()][0] = 0;
//                }else if (listAllSno.contains(list1.get(j)) && a.getState() == 0){
//                    count[a.getState()][0] = count[a.getState()][0];
//                }else {
//                    count[a.getState()][0] = count[a.getState()][0] + 1;
//                }
//            }
//        }
//        for (int j = 0; j < listAllSno.size(); j++) {
//            String sno = String.valueOf(listAllSno.get(j));
//            listAllInformation.add(studentDao.findStudentByID(sno));
//        }
//        listAllInformation.add(count);
//        return listAllInformation;
//    }
    @Override
    public List AllStudentInformation(String CName, int state) {
        List list = dataStatisticsDao.AllClass(CName, state);
        List listAllInformation = new ArrayList();
        List listAllSno = new ArrayList();
        int[][] count = new int[99999999][1];
        for (int i = 0; i < list.size(); i++) {
            List list1 = (List) list.get(i);
            for (int j = 0; j < list1.size(); j++) {
                Integer no = Integer.valueOf(list1.get(j).toString());
                if (!listAllSno.contains(list1.get(j))){
                    listAllSno.add(list1.get(j));
                    count[no][0] = 1;
                }else {
                    count[no][0] = count[no][0] + 1;
                }
            }
        }

        for (int j = 0; j < listAllSno.size(); j++) {
            String sno = String.valueOf(listAllSno.get(j));
            listAllInformation.add(studentDao.findStudentByID(sno));
        }
        listAllInformation.add(count);
        return listAllInformation;
    }
}
