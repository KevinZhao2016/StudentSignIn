package com.server.impl;

/**
 * Created by Mediv on 2018/7/10.
 */
import com.dao.impl.AdminDaoImpl;
import com.server.AdLoginServer;

public class AdLoginServerImpl implements AdLoginServer{
    @Override
    public String Login(String userName, String passWord){
        AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
        return adminDaoImpl.Login(userName,passWord);
    }

}

