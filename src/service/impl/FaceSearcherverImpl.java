package service.impl;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.model.StudentEntity;
import com.util.AipFaceUtil;
import service.FaceSerachServer;

public class FaceSearcherverImpl implements FaceSerachServer {
    @Override
    public StudentEntity FindStudentByFace(String image){
        AipFaceUtil aipFaceUtil = new AipFaceUtil();
        String StudentID = aipFaceUtil.FaceSearch(image);
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findStudentByID(StudentID);
    }
}
