package com.maven.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppAction {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "json1")
    public Map  json1()
    {

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("error", "111");
        return map;
    }

}
