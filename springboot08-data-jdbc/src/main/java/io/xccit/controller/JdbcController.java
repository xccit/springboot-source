package io.xccit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-08-08
 * @description
 */
@Controller
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/list")
    public List<Map<String,Object>> getDeptList(){
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from department");
        return mapList;
    }
}
