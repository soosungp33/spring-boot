package ProblemData.spring.web;

import ProblemData.spring.domain.SubmitData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class GoEngine {
    private static RestTemplate restTemplate;

    public static ResponseEntity<SubmitData> sendEngine(String number) {
        int SubNum = 123;
        int Pnum = 1;
        Object Pcode = "코드";
        SubmitData requestDto = SubmitData.builder()
                .SubNum(SubNum)
                .Pnum(Pnum)
                .Pcode(Pcode)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<SubmitData> entity = new HttpEntity<>(requestDto, headers);


        String url = "http://localhost:8080/" + number;

        ResponseEntity<SubmitData> res = restTemplate.exchange(url, HttpMethod.POST, entity, SubmitData.class);

        return res;
    }
}
