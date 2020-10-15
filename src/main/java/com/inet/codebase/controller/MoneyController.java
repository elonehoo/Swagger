package com.inet.codebase.controller;

import com.inet.codebase.utlis.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * MoneyController
 *
 * @author HCY
 * @since 2020/10/15
 */
@RestController
@CrossOrigin
@RequestMapping("/money")
@Api(value = "money接口" , tags = {"money接口"})
public class MoneyController {

    @ApiOperation("GET接口")
    @GetMapping("/home")
    public Result GetHome(){
        return new Result("GET了money中的home请求","get请求",100);
    }
    @ApiOperation("POST接口")
    @PostMapping("/home")
    public Result PostHome(){
        return new Result("POST了money中的home请求","post请求",100);
    }
    @ApiOperation("DELETE接口")
    @DeleteMapping("/home")
    public Result DeleteHome(){
        return new Result("DELETE了money中的home请求","delete请求",100);
    }
    @ApiOperation("PUT接口")
    @PutMapping("/home")
    public Result PutHome(){
        return new Result("PUT了money中的home请求","put请求",100);
    }

}
