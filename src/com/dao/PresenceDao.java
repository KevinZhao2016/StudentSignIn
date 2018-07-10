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

//    Boolean DeleteStudent(String id);
}
