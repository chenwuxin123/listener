package com.meipiao.ctrip_applepie.listener.utils;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author sainentl
 * @create 2020-03-30 16:47
 */
@Configuration
public class RabbitMQConfig extends SimpleMessageConverter {
    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        Object content = null;
        MessageProperties properties = message.getMessageProperties();
        if (properties != null) {
            String contentType = properties.getContentType();
            if (contentType != null && contentType.startsWith("text")) {
                String encoding = properties.getContentEncoding();
                if (encoding == null) {
                    encoding = super.DEFAULT_CHARSET;
                }
                try {
                    if ("gzip".equals(encoding)) {
                        content = new String(GzipUtil.uncompress(message.getBody()));
                    } else {
                        content = new String(message.getBody(), encoding);
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new MessageConversionException(
                            "failed to convert text-based Message content", e);
                }
            }
        }
        if (content == null) {
            content = message.getBody();
        }
        return content;
    }
}
