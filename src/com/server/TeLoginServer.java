package com.server;

import java.util.List;
/**
 * Created by Mediv on 2018/7/10.
 */
public interface TeLoginServer {
    String Login(String TuserName, String TpassWord);
    List<String> SelectCourse(String TuserName);
    int CourseId(String CName, int Cno);
}
