package com.action;

import com.model.AllClassResultEntity;
import com.server.PresenceInfoServer;
import com.server.impl.DataStatisticsServerImpl;
import com.server.impl.PresenceInfoServerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllClassInfoAction {
    private List<AllClassResultEntity> list;

    public List<AllClassResultEntity> getList() {
        return list;
    }

    public void setList(List<AllClassResultEntity> list) {
        this.list = list;
    }

    public String GetAllClassInfo() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        String cname = request.getParameter("cname");

        PresenceInfoServer presenceInfoServer = new PresenceInfoServerImpl();
        List<AllClassResultEntity> list = presenceInfoServer.GetAllClassResult(cname);
        if(list!=null){
            this.setList(list);
            return "success";
        }else{
            return "fail";
        }
    }
}
