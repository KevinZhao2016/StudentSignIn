package com.server.impl;

import com.model.AllClassResultEntity;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class PresenceInfoServerImplTest {

    PresenceInfoServerImpl presenceInfoServer = new PresenceInfoServerImpl();
    @Test
    public void getAllClassResult() {
        List<AllClassResultEntity> list =  presenceInfoServer.GetAllClassResult("数据结构");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getStudentEntity().getsName());
        }
    }
}