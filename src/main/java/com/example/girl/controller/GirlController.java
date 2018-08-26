package com.example.girl.controller;


import com.example.girl.dao.GirlDao;
import com.example.girl.entity.Girl;
import com.example.girl.entity.Result;
import com.example.girl.service.GirlService;
import com.example.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="girl")
public class GirlController {

    @Autowired
    private GirlService girlService;

    @GetMapping("/getGirls")
    public List<Girl> getGirls(){
        List<Girl> list = girlService.findAll();
        return list;
    }

    @GetMapping(value="getGirls/{id}")
    public Girl getGirls(@PathVariable("id") Integer id){
        return girlService.findOne(id);
    }

    @GetMapping("getGirls/age")
    public List<Girl> getGirlsByAge(@RequestParam("age") Integer age){
        List<Girl> list = girlService.findByAge(age);
        return list;
    }

    @PostMapping("addGirl")
    public Result<Girl> addGirl(@Valid Girl g , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResultUtil.faild(1,bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResultUtil.success(girlService.save(g));
    }

    @PutMapping("updateGirl")
    public Result<Girl> updateGirl(Girl g){
        return ResultUtil.success(girlService.save(g));
    }

    @DeleteMapping("deleteGirl/{id}")
    public Result deleteGirl(@PathVariable("id") Integer id){
        girlService.delete(id);
        return ResultUtil.success();
    }

    @PostMapping("tx")
    public Result<Girl> tx(@Valid Girl g , BindingResult bindingResult){//throws Exception{

        if(bindingResult.hasErrors()){
            return ResultUtil.faild(1,bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResultUtil.success(girlService.tx(g));
    }
}
