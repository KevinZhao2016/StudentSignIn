package com.server;

import com.model.PresenceEntity;

import java.sql.Timestamp;

public interface SignInServer {
    Boolean GetSignInStatus(String sno, int CID);

    Boolean AddPresence(PresenceEntity presenceEntity);

    PresenceEntity SetPresenceEntity(String sno, int cid);
}
