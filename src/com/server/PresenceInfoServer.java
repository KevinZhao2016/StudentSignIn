package com.server;

import com.model.AllClassResultEntity;
import com.model.SingleClassResultEntity;

import java.util.List;

public interface PresenceInfoServer {

    List<AllClassResultEntity> GetAllClassResult(String Cname);

    List<SingleClassResultEntity> GetSingleClassResult(String Cname,int Cno);

    List<SingleClassResultEntity> GetSingleClassResult(String Cname,int Cno,int State);

}
