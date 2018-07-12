package com.server;

import com.model.AllClassResultEntity;

import java.util.List;

public interface PresenceInfoServer {

    List<AllClassResultEntity> GetAllClassResult(String Cname);

}
