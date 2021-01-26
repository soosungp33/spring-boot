package ProblemData.spring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성
@NoArgsConstructor
public class SubmitData {
    private int SubNum;
    private int Pnum;
    private Object Pcode;

    @Builder
    public SubmitData(int SubNum, int Pnum, Object Pcode) {
        this.SubNum = SubNum;
        this.Pnum = Pnum;
        this.Pcode = Pcode;
    }
}
