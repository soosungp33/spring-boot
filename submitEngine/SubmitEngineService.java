package ProblemData.spring.service;

import ProblemData.spring.domain.SubmitData;
import ProblemData.spring.web.GoEngine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubmitEngineService {
    public ResponseEntity<SubmitData> addData(String number) {
        return GoEngine.sendEngine(number);
    }
}
