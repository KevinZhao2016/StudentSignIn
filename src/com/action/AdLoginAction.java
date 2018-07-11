package com.action;

/**
 * Created by Mediv on 2018/7/10.
 */
import com.opensymphony.xwork2.ActionContext;
import com.server.impl.AdLoginServerImpl;
import java.util.Map;

public class AdLoginAction {
    private String userName;
    private String passWord;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassWord(){
        return passWord;
    }
    public  void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String execute() throws Exception {
        System.out.println(this.userName);
        System.out.println(this.passWord);
        AdLoginServerImpl adloginServerImpl = new AdLoginServerImpl();
        String Name = adloginServerImpl.Login(userName,passWord);
        if (Name != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("userName",Name);
            return "success";
        } else
            return "fail";
    }
}
