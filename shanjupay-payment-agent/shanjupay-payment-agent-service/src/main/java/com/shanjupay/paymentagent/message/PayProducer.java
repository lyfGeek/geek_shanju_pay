package com.shanjupay.paymentagent.message;

import com.alibaba.fastjson.JSON;
import com.shanjupay.paymentagent.api.dto.PaymentResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PayProducer {

    // 订单结果查询主题。
    private static final String TOPIC_ORDER = "TP_PAYMENT_ORDER";
    // 订单结果 主题。
    private static final String TOPIC_RESULT = "TP_PAYMENT_RESULT";
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    // 发送消息（查询支付宝、微信订单状态）。
    public void payOrderNotice(PaymentResponseDTO paymentResponseDTO) {
        // 发送延迟消息。
        Message<PaymentResponseDTO> message = MessageBuilder.withPayload(paymentResponseDTO).build();
        // 延迟第 3 级发送（延迟 10 秒）。
        rocketMQTemplate.syncSend(TOPIC_ORDER, message, 1000, 3);
        log.info("支付渠道代理服务向 mq 发送订单查询的消息：{}", JSON.toJSONString(paymentResponseDTO));
    }

    // 发送消息（支付结果）。
    public void payResultNotice(PaymentResponseDTO paymentResponseDTO) {
        rocketMQTemplate.convertAndSend(TOPIC_RESULT, paymentResponseDTO);
        log.info("支付渠道代理服务向 mq 支付结果消息：{}", JSON.toJSONString(paymentResponseDTO));
    }

}
