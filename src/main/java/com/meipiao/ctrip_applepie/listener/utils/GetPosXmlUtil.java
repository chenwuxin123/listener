package com.meipiao.ctrip_applepie.listener.utils;

import com.meipiao.ctrip_applepie.listener.config.CtripConfig;
import org.anyline.entity.DataRow;

/**
 * @Author: Chenwx
 * @Date: 2020/3/26 15:26
 */
public class GetPosXmlUtil {

    //获取pos节点相关账户信息
    public static DataRow getPos(DataRow row) {
        //获取携程用户信息
        CtripConfig ctripConfig = SpringUtil.getBean(CtripConfig.class);

        row.put("ID", ctripConfig.getID());
        row.put("MessagePassword", ctripConfig.getMessagePassword());
        row.put("CodeContext", ctripConfig.getCodeContext());
        return row;
    }
}
