package ProblemData.spring.Controller;

import ProblemData.spring.domain.SubmitData;
import ProblemData.spring.service.SubmitEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Queue;

import java.util.concurrent.ArrayBlockingQueue;

@RequiredArgsConstructor
@RestController
public class SubmitEngineController {

    //Queue<String> server = new LinkedList<String>();
    ArrayBlockingQueue<String> server = new ArrayBlockingQueue<String> (6);

    private final SubmitEngineService submitEngineService;

    @PostMapping("제출버튼 눌렀을 때 value") // 제출 요청 수행
    public String requestData(String contents) throws InterruptedException {
        /*
        제출 정보 받는 부분
        */

        // 채점 엔진으로 보내는 부분
        int number = server.size()+1;
        server.put(Integer.toString(number)); // queue가 full이면 여유 공간이 생길 때까지 기다림

        // 원래라면 파라미터로 제출 정보도 보내주기
        ResponseEntity<SubmitData> responseEntity = submitEngineService.addData(server.peek());
        // responseEntity.getStatusCode()가 200이면 성공적으로 간 것
        server.remove();

        /*
        채점 결과 받는 코드
         */

        return ""; // 엔진에서 온 채점 결과에 따라 정답 or 오답
    }
}
