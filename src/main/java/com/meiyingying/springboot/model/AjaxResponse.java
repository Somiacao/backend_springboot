package com.meiyingying.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AjaxResponse {

    @ApiModelProperty("是否请求成功")
    private boolean isOk;
    @ApiModelProperty("响应码")
    private int code;
    private String state;
    private Object data;

    private AjaxResponse(){}

    public static AjaxResponse success(){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setOk(true);
        resultBean.setCode(200);
        resultBean.setState("success");
        return resultBean;
    }

    public static AjaxResponse success(Object object){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setOk(true);
        resultBean.setCode(200);
        resultBean.setState("success");
        resultBean.setData(object);
        return resultBean;
    }
}
