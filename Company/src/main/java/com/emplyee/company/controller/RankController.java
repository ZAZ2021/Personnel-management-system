package com.emplyee.company.controller;

import com.emplyee.company.mapper.RankMapper;
import com.emplyee.company.pojo.Ran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class RankController {

    @Autowired
    private RankMapper rankMapper;

    @PostMapping("/updateprice")
    public Integer Create(@RequestBody Ran rank){
        return rankMapper.updatePrice(rank);
    }

    @GetMapping("/rank/find")
    public List<Ran> Find(){
        return rankMapper.Find();
    }
}
