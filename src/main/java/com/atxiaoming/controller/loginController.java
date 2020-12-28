package com.atxiaoming.controller;


import com.atxiaoming.entity.TbRole;
import com.atxiaoming.service.impl.TbUserServiceImpl;
import com.atxiaoming.vo.LoginVo;
import com.atxiaoming.vo.RespBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "登录接口")
@RestController
@RequestMapping("")
@Slf4j
public class loginController {

    @Autowired
    private TbUserServiceImpl userServiceI;

    @ApiOperation(value = "登录" ,  notes="登录接口")
    @RequestMapping(value="/login",method= RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public RespBean doLogin(@RequestBody LoginVo loginVo){
        return userServiceI.doLogin(loginVo);
    }
}