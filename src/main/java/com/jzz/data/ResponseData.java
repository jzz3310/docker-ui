package com.jzz.data;

import lombok.Data;

/**
 * @author:jzz
 * @date:2020/12/12
 */
@Data
public class ResponseData {
    private boolean status;
    private String message;
    private Object data;

    public static ResponseData success (String message) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(true);
        responseData.setMessage(message);
        return responseData;
    }

    public static ResponseData fail (String message) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(false);
        responseData.setMessage(message);
        return responseData;
    }

    public static ResponseData success (String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(true);
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData fail (String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(false);
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData result (Boolean status, String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(status);
        responseData.setMessage(message + (status?"成功":"失败"));
        responseData.setData(data);
        return responseData;
    }




}
