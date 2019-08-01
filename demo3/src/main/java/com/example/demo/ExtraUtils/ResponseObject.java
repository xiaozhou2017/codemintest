package com.example.demo.ExtraUtils;

import java.util.HashMap;
/**
 * response
 * {
 *     code
 *     message
 *     object
 * }
 */
public class ResponseObject {
    public static final int ResponseCode_Success=200;
    public static final int ResponseCode_COMMON_ERROE=105;
    private Object data;
    private  int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public  ResponseObject(int code, String message){

        this.code = code;
        this.message = message;

        this.data = new HashMap<String, Object>();
    }

    public static ResponseObject success(){

        ResponseObject object = new ResponseObject(ResponseCode_Success,"success");
        return object;

    }
    public static ResponseObject error(){

        ResponseObject object = new ResponseObject(ResponseCode_COMMON_ERROE,"默认出错信息");
        return object;

    }


    public static ResponseObject success(Object data){
        ResponseObject object = new ResponseObject(ResponseCode_Success,"success");
        object.setData(data);
        return object;

    }


    public static ResponseObject error(int code,String message){

        ResponseObject object = new ResponseObject(code,message);
        return object;

    }












}

