package service;

import com.model.StudentEntity;

public interface FaceSerachServer {
    StudentEntity FindStudentByFace(String face);
}
