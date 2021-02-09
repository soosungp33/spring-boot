package ProblemData.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
public class ReqUserSolvData {

    static HttpHeaders headers = new HttpHeaders();

    /*
    resUserSolvData {
        ...
        ResponseEntity<String> fresp = reqUserSolvData(ID);
        ...
    }
     */
    public ResponseEntity<String> reqUserSolvData(String ID) {
        // make Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("ID", ID);
        System.out.println(params.toString());

        // make Entity
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(params, headers);
        RestTemplate rt = new RestTemplate();
        String url = "url";
        return rt.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
