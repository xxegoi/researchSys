package com.example.demo.services;

<<<<<<< HEAD:src/main/java/com/example/demo/services/ResultService.java
import com.example.demo.pojo.Result;

import java.util.List;

public interface ResultService {

    Result GetResult(String user, int questionId,int researchId);

    int insert(Result result);

    int update(Result result);

    int delete(int Id);

    List<Result> getAllByResearchIdAndUser(String user, int researchId);
=======
public class BaseService {
>>>>>>> parent of c074f7b... Test OK:src/main/java/com/example/demo/services/BaseService.java
}
