package ProblemData.spring;

import ProblemData.spring.Controller.SendUserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SendUserData.class)
public class SendUserDataTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void userdata_return() throws Exception {
        int Pnum = 1;
        String Pname = "A+B";
        String Solved = "T";

        mvc.perform(
                get("/spring/ProblemData")
                .param("Pnum", String.valueOf(Pnum))
                .param("Pname", Pname)
                .param("Solved", Solved)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.Pnum", is(Pnum)))
        .andExpect(jsonPath("$.Pname", is(Pname)))
        .andExpect(jsonPath("$.Solved", is(Solved)));
    }
}
