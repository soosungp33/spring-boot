package ProblemData.spring.Controller;

import ProblemData.spring.domain.UserData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SendUserData {

    @RequestMapping(value = "/spring/ProblemData", method = RequestMethod.POST)
    public UserData setProblems(@RequestParam("Pnum") int Pnum, // 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
                                @RequestParam("Pname") String Pname,
                                @RequestParam("Solved") String Solved) {
        return new UserData(Pnum, Pname, Solved);
    }


}
