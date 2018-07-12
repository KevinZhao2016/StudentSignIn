package com.action;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
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
    private int totalNum;
    private int presentNum;
    private double presentRate;
    private int lateNum;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getPresentNum() {
        return presentNum;
    }

    public void setPresentNum(int presentNum) {
        this.presentNum = presentNum;
    }

    public double getPresentRate() {
        return presentRate;
    }

    public void setPresentRate(double presentRate) {
        this.presentRate = presentRate;
    }

    public int getLateNum() {
        return lateNum;
    }

    public void setLateNum(int lateNum) {
        this.lateNum = lateNum;
    }

    public List<SingleClassResultEntity> getList() {
        return list;
    }

    public void setList(List<SingleClassResultEntity> list) {
        this.list = list;
    }

    public String GetSingleClassInfo() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        String cname = request.getParameter("cname");
        int cno = new Integer(request.getParameter("cno")).intValue();
        System.out.println(cname);
        PresenceInfoServer presenceInfoServer = new PresenceInfoServerImpl();
        List<SingleClassResultEntity> list = presenceInfoServer.GetSingleClassResult(cname, cno);
        if (list != null) {
            this.setList(list);
            StudentDao studentDao = new StudentDaoImpl();
            this.setTotalNum(studentDao.ListStudent().size());
            this.setPresentNum(list.size());
            this.setPresentRate(1.0 * presentNum / totalNum);
            return "success";
        } else {
            return "fail";
        }
    }

    public String GetSingleClassInfoWithState() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DataStatisticsServerImpl dataStatisticsServerImpl = new DataStatisticsServerImpl();
        String cname = request.getParameter("cname");
        int cno = new Integer(request.getParameter("cno")).intValue();
        int state = new Integer(request.getParameter("state")).intValue();
        PresenceInfoServer presenceInfoServer = new PresenceInfoServerImpl();
        List<SingleClassResultEntity> list = presenceInfoServer.GetSingleClassResult(cname, cno, state);
        if (list != null) {
            this.setList(list);
            StudentDao studentDao = new StudentDaoImpl();
            this.setTotalNum(studentDao.ListStudent().size());
            this.setPresentNum(list.size());
            this.setLateNum(presenceInfoServer.GetSingleClassResult(cname, cno, 1).size());
            this.setPresentRate(1.0 * presentNum / totalNum);
            return "success";
        } else {
            return "fail";
        }
    }
}
