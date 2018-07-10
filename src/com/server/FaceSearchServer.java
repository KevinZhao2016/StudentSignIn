package com.server;

import com.model.StudentEntity;

public interface FaceSearchServer {
    StudentEntity FindStudentByFace(String face);
}
