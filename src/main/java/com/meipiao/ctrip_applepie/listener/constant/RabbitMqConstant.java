package com.meipiao.ctrip_applepie.listener.constant;

/**
 * @Author: Chenwx
 * @Date: 2020/4/2 14:53
 * @Des: MQ的常量
 */
public interface RabbitMqConstant {

    //交换机名称
    String HOTEL_EXCHANGE = "Roc";

    //路由key名称
    String HOTEL_KEY = "Roc";

    //酒店推动事件队列名称
    String HOTEL_PUSH_QUEUE = "HotelPush";

    //酒店变动事件队列名称
    String HOTEL_CHANGE_QUEUE = "HotelChange";
}
