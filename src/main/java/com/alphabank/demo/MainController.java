package com.alphabank.demo;

import com.alphabank.demo.entity.Input;
import com.alphabank.demo.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class MainController {
    private MainService service;

    @Autowired
    public MainController(MainService service) {
        this.service = service;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST,
            consumes = {"application/json"})
    public @ResponseBody List<Integer> post(@RequestBody Input input) {
        log.info("input is " + input);
        return service.selectItems(input);
    }
}
