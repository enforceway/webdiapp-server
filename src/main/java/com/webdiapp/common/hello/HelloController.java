package com.webdiapp.common.hello;

import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.questionaire.service.QuestionaireService;
import com.webdiapp.questionaire.vo.QuestionaireVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello, welcome to webdiapp application!";
    }
}
