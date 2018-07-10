package com.server;

import com.model.StudentEntity;

public interface StudentRegistServer {
    String FaceAdd(String face, String id);

    Boolean InfoRegist(StudentEntity student);
}
