package com.onlinej.judge.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IsIDUnique {
    public ResponseEntity<String> IsIDUnique(String ID){

        /** body 만들기 **/
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("ID", ID);

        /** header 만들기 **/
        HttpHeaders headers = new HttpHeaders();

        /** body, header 합치기 **/
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        /** POST 요청하기 **/
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://{요청할 서버 주소}", //{요청할 서버 주소}
                HttpMethod.POST, //{요청할 방식}
                entity, // {요청할 때 보낼 데이터}
                String.class //{요청시 반환되는 데이터 타입}
        );

        return response;
    }
}