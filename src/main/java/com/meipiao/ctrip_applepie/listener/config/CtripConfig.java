package com.meipiao.ctrip_applepie.listener.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:ctrip.properties"})
@ConfigurationProperties(prefix = "ctrip")

//头信息配置导入
public class CtripConfig {

    private String ID;
    private String MessagePassword;
    private String Type;
    private String Code;
    private String CodeContext;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessagePassword() {
        return MessagePassword;
    }

    public void setMessagePassword(String messagePassword) {
        MessagePassword = messagePassword;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCodeContext() {
        return CodeContext;
    }

    public void setCodeContext(String codeContext) {
        CodeContext = codeContext;
    }

    @Override
    public String toString() {
        return "Ctrip{" +
                "ID='" + ID + '\'' +
                ", MessagePassword='" + MessagePassword + '\'' +
                ", Type='" + Type + '\'' +
                ", Code='" + Code + '\'' +
                ", CodeContext='" + CodeContext + '\'' +
                '}';
    }
}
