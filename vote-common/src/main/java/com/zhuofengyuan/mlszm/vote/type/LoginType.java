package com.zhuofengyuan.mlszm.vote.type;

public enum LoginType {

    wechat("wx"), tencent("qq"), normal("normal");

    private String value;
    LoginType(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
