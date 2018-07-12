package com.action;

import com.model.AllClassResultEntity;
import com.model.PresenceEntity;
import com.model.StudentEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.PresenceInfoServer;
import com.server.impl.DataStatisticsServerImpl;
import com.server.impl.PresenceInfoServerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Gavin on 2018/7/11.
 */
public class DataStatisticsAction {
    private String cname;
    private int cno;
    private int state;
    private List list;
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
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
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        this.cname = request.getParameter("cname");
        this.cno = new Integer(request.getParameter("cno")).intValue();
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        List listCount = dataStatisticsServerImpl.GetCount(cname, cno);
        System.out.println(cno);
        if (listCount != null) {
//            ActionContext actionContext = ActionContext.getContext();
//            Map session = actionContext.getSession();
//            session.put("listCount", listCount);
            this.setList(listCount);
            return "success";
        } else {
            return "fail";
        }
    }

    public String SingleClass() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        this.cname = request.getParameter("cname");
        this.cno = new Integer(request.getParameter("cno")).intValue();
        this.state = new Integer(request.getParameter("state")).intValue();
        List listSingle = dataStatisticsServerImpl.SingleStudentInformaiton(cname, cno, state);
        if (listSingle != null) {
//            ActionContext actionContext = ActionContext.getContext();
//            Map session = actionContext.getSession();
//            session.put("listSingle", listSingle);
            this.setList(listSingle);
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
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        this.cname = request.getParameter("cname");
        this.state = new Integer(request.getParameter("state")).intValue();
        List listAll = dataStatisticsServerImpl.AllStudentInformation(cname, state);
        if (listAll != null) {
//            ActionContext actionContext = ActionContext.getContext();
//            Map session = actionContext.getSession();
//            session.put("listAll", listAll);
            this.setList(listAll);
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
