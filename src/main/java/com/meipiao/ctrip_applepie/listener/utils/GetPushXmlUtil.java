package com.meipiao.ctrip_applepie.listener.utils;

import org.anyline.entity.DataRow;
import org.anyline.entity.DataSet;
import org.anyline.util.BasicUtil;
import org.anyline.util.regular.RegularUtil;

import java.util.List;

/**
 * @Author: Chenwx
 * @Date: 2020/3/25 8:51
 * @Des: 赋值于xml
 */
public class GetPushXmlUtil {
    //获取postxml
    public static String getXml(String xml, DataRow row) throws Exception {
        return getXml(xml, row, null);
    }

    //获取postxml
    public static String getXml(String xml, DataRow row, String tag) throws Exception {
        boolean flag = false;
        if (BasicUtil.isEmpty(tag)) {//默认查找${},tag有值查找tag{}
            tag = "$";
            flag = true;
        }
        //获取xml中所有占位符
        List<String> fetch = null;
        if (flag) {
            fetch = RegularUtil.fetch(xml, "\\" + tag + "\\{.*?\\}");
        } else {
            fetch = RegularUtil.fetch(xml, tag + "\\{.*?\\}");
        }
        //循环所有占位符
        for (String key : fetch) {
            if (BasicUtil.isNotEmpty(key)) {
                //去掉{},保留key
                key = key.substring(key.indexOf("{") + 1, key.length() - 1);
                if (key.indexOf("-array-start") != -1) {//获取循环体
                    String start = key;
                    String end = key.replace("-start", "-end");//获取结尾标签
                    int startIndex = xml.indexOf(key) + key.length() + 1;//循环内容开始坐标,加上key的长度和}的长度,获取完整标签长度
                    int endIndex = xml.indexOf(end) - (tag.length() + 1);//循环内容结束坐标,tag长度+一个{的长度,截取中间内容
                    String tempXml = xml.substring(startIndex, endIndex);//循环内容文本

                    String resultXml = "";
                    key = key.replace("-start", "");//获取key
                    DataSet tempSet = row.getSet(key);//获取参数set
                    if (BasicUtil.isEmpty(tempSet)) {
                        xml = replaceLongStr(xml, tempXml, "");//清空循环
                    } else {
                        for (DataRow dataRow : tempSet) {
                            resultXml += getXml(tempXml, dataRow, key);//每一个row  递归替换xml文本
                        }
                        xml = replaceLongStr(xml, tempXml, resultXml);//将初始循环体替换为循环后的xml
                    }
                    xml = xml.replace(tag + "{" + start + "}", "").replace(tag + "{" + end + "}", "");//去掉循环标签
                } else if (key.indexOf("-array-end") == -1) {//排除循环结束标签
                    //获取值
                    String value = row.getString(key);
                    //值为空的话去掉占位符
                    if (BasicUtil.isEmpty(value)) {
                        xml = xml.replace(tag + "{" + key + "}", "");
                    } else {
                        //不需要名称的占位符,直接赋值value
                        if (key.indexOf("-notag") >= 0) {
                            xml = xml.replace(tag + "{" + key + "}", value);
                        } else {//拼接为key=value
                            xml = xml.replace(tag + "{" + key + "}", key + "=\"" + value + "\"");
                        }
                    }
                }
            }
        }
        return xml;
    }

    //大文本替换方法,replace替换无效
    public static String replaceLongStr(String str, String fromStr, String toStr) {
        StringBuffer result = new StringBuffer();
        if (BasicUtil.isNotEmpty(str)) {
            while (str.indexOf(fromStr) > 0) {
                result.append(str.substring(0, str.indexOf(fromStr)));
                result.append(toStr);
                str = str.substring(str.indexOf(fromStr) + fromStr.length(), str.length());
            }
            result.append(str);
        }
        return result.toString();
    }
}
