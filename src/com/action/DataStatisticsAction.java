package com.action;

import com.model.PresenceEntity;
import com.model.StudentEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.impl.DataStatisticsServerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Gavin on 2018/7/11.
 */
public class DataStatisticsAction {
    private String cname;
    private int cno;
    private int state;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCname() {
        return cname;
    }
    public void setCname(String cname){
        this.cname = cname;
    }

    public String CountRate() throws Exception {
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        List listCount = dataStatisticsServerImpl.GetCount(cname, cno);
        if (listCount != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("listCount", listCount);
            return "success";
        } else {
            return "fail";
        }
    }

    public String SingleClass() throws Exception {
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();

        List listSingle = dataStatisticsServerImpl.SingleStudentInformaiton(cname, cno, state);

        if (listSingle != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("listSingle", listSingle);
            return "success";
        } else {
            return "fail";
        }
//        if(state == 0 || state == 1){
//            for(int i = 0; i < listSingle.size() - 1; i++) {
//                StudentEntity a = (StudentEntity)listSingle.get(i);
//                System.out.print(a.getSid());System.out.print(" ");
//                System.out.print(a.getsName());System.out.print(" ");
//                System.out.print(a.getSno());System.out.print(" ");
//                System.out.print(a.getsMajor());System.out.print(" ");
//                System.out.print(a.getsAge());System.out.print(" ");
//                System.out.print(a.getToken());System.out.println(" ");
//            }
//            List list1 = (List)listSingle.get(listSingle.size() - 1);
//            for(int i = 0; i < list1.size(); i++){
//                PresenceEntity a = (PresenceEntity)list1.get(i);
//                System.out.println(a.getTime());
//            }
//        }else {
//            for(int i = 0; i < listSingle.size(); i++) {
//                StudentEntity a = (StudentEntity)listSingle.get(i);
//                System.out.print(a.getSid());System.out.print(" ");
//                System.out.print(a.getsName());System.out.print(" ");
//                System.out.print(a.getSno());System.out.print(" ");
//                System.out.print(a.getsMajor());System.out.print(" ");
//                System.out.print(a.getsAge());System.out.print(" ");
//                System.out.print(a.getToken());System.out.println(" ");
//            }
//        }
    }

    public String AllClass() throws Exception {
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        List listAll = dataStatisticsServerImpl.AllStudentInformation(cname, state);
        if (listAll != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("listAll", listAll);
            return "success";
        } else {
            return "fail";
        }
        //int[][] count = (int[][])listAll.get(listAll.size() - 1);
//        for(int i = 0; i < listAll.size() - 1; i++) {
//            StudentEntity a = (StudentEntity) listAll.get(i);
//            Integer no = Integer.valueOf(a.getSno());
//            System.out.print(a.getSid());System.out.print(" ");
//            System.out.print(a.getsName());System.out.print(" ");
//            System.out.print(a.getSno());System.out.print(" ");
//            System.out.print(a.getsMajor());System.out.print(" ");
//            System.out.print(a.getsAge());System.out.print(" ");
//            System.out.print(a.getToken());System.out.print(" ");
//            System.out.println(count[no][0]);
//        }
    }
}
