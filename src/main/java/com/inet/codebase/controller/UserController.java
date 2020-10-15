package com.inet.codebase.controller;

import com.inet.codebase.utlis.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @author HCY
 * @since 2020/10/15
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(value = "基础接口名字为user",tags = {"user接口"})
public class UserController {

    @ApiOperation("GET接口")
    @GetMapping("/home")
    public Result GetHome(){
        return new Result("GET了user中的home请求","get请求",100);
    }

    @ApiOperation("POST接口")
    @PostMapping("/home")
    public Result PostHome(){
        return new Result("POST了user中的home请求","post请求",100);
    }
    @ApiOperation("DELETE接口")
    @DeleteMapping("/home")
    public Result DeleteHome(){
        return new Result("DELETE了user中的home请求","delete请求",100);
    }

    @ApiOperation("PUT接口")
    @PutMapping("/home")
    public Result PutHome(){
        return new Result("PUT了user中的home请求","put请求",100);
    }

}
