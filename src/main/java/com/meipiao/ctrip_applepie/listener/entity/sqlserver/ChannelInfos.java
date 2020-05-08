package com.meipiao.ctrip_applepie.listener.entity.sqlserver;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 15:06
 */
public class ChannelInfos implements Serializable {
    private Long id;

    private String name;

    private int channelType;

    private Date creatTime;

    private int dataFlag;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public int getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(int dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ChannelInfos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", channelType=" + channelType +
                ", creatTime=" + creatTime +
                ", dataFlag=" + dataFlag +
                ", remark='" + remark + '\'' +
                '}';
    }
}
