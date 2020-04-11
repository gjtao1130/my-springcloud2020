package com.sky.cloud2020.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {
    private Integer code;
    private String message;
    private Object data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

    public static CommonResult buildSuccess(Object data){
        return new CommonResult(0,"成功", data);
    }
    public static CommonResult buildSuccess(){
        return new CommonResult(0,"成功", null);
    }

    public static CommonResult buildFailure(){
        return new CommonResult(-1,"失败", null);
    }

    public static CommonResult buildFailure(Object data){
        return new CommonResult(-1,"失败", data);
    }

    public static CommonResult buildFailure(int code, String message){
        return new CommonResult(code, message, null);
    }

    public static CommonResult buildFailure(String message){
        return new CommonResult(-1, message, null);
    }
}
