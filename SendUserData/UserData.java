package ProblemData.spring.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor // 선언된 모든 fianl 필드가 포함된 생성자를 생성
public class UserData {
    private final int Pnum;
    private final String Pname;
    private final String Solved;
}
