package com.action;

import com.model.SingleClassResultEntity;
import com.server.PresenceInfoServer;
import com.server.impl.DataStatisticsServerImpl;
import com.server.impl.PresenceInfoServerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetSingleInfoAction {
    private List<SingleClassResultEntity> list;

    public List<SingleClassResultEntity> getList() {
        return list;
    }

    public void setList(List<SingleClassResultEntity> list) {
        this.list = list;
    }

    public String GetSingleClassInfo() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        String cname = request.getParameter("cname");
        int cno = new Integer(request.getParameter("cno")).intValue();
        System.out.println(cname);
        PresenceInfoServer presenceInfoServer = new PresenceInfoServerImpl();
        List<SingleClassResultEntity> list = presenceInfoServer.GetSingleClassResult(cname,cno);
        if(list!=null){
            this.setList(list);
            return "success";
        }else{
            return "fail";
        }
    }

    public String GetSingleClassInfoWithState() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        String cname = request.getParameter("cname");
        int cno = new Integer(request.getParameter("cno")).intValue();
        int state = new Integer(request.getParameter("state")).intValue();
        PresenceInfoServer presenceInfoServer = new PresenceInfoServerImpl();
        List<SingleClassResultEntity> list = presenceInfoServer.GetSingleClassResult(cname,cno,state);
        if(list!=null){
            this.setList(list);
            return "success";
        }else{
            return "fail";
        }
    }
}
