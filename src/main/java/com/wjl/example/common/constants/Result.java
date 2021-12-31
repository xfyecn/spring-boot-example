package com.wjl.example.common.constants;

import com.wjl.example.common.enums.HttpStatus;
import lombok.Data;

/**
 * @author: wjl
 * @date: 2021/12/31 15:27
 * @version: v1.0
 */
@Data
public class Result<T> {

    private int status;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> Result = new Result<>();
        Result.setStatus(HttpStatus.OK.getCode());
        Result.setMsg(HttpStatus.OK.getMsg());
        Result.setData(data);
        return Result;
    }

    public static <T> Result<T> success(String msg) {
        Result<T> Result = new Result<>();
        Result.setStatus(HttpStatus.OK.getCode());
        Result.setMsg(msg);
        return Result;
    }

    public static <T> Result<T> fail(int code, String msg) {
        Result<T> Result = new Result<>();
        Result.setStatus(code);
        Result.setMsg(msg);
        return Result;
    }

}
