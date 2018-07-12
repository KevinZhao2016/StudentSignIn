package com.dao;

import com.model.PresenceEntity;

import java.util.List;

public interface PresenceDao {
    List ListPresence();

//    int RegisterStudent(PresenceEntity presenceEntity);
//
//    Boolean UpdateUser(PresenceEntity presenceEntity);

    Boolean PresenceAdd(PresenceEntity presenceEntity);

    PresenceEntity findPresenceBySnoAndCID(String sno, int CID);

    List<PresenceEntity> findPresenceByStateAndCID(int State,int CID);

    List<PresenceEntity> findPresenceByCID(int CID);

//    PresenceEntity findPresenceByCname(String Cname);

//    Boolean DeleteStudent(String id);
}
