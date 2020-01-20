package com.cn.config;

import com.cn.constants.ConsumerConstant;
import com.cn.constants.ProducerConstant;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by xiao
 * @Classname KafkaConfiguration
 * @Description  kafka配置类
 * @Date 2020/1/10 9:57
 */
@Configuration
@EnableKafka
public class KafkaConfiguration {

    /**
     * ConcurrentKafkaListenerContainerFactory为创建Kafka监听器的工程类，这里只配置了消费者
     *
     * @return
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<Integer, String>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    /**
     * 根据consumerProps填写的参数创建消费者工厂
     *
     * @return
     */
    @Bean
    public ConsumerFactory consumerFactory() {
        return new DefaultKafkaConsumerFactory(consumerProps());
    }

    /**
     * 根据senderProps填写的参数创建生产者工厂
     *
     * @return
     */
    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<Integer, String>(senderProps());
    }


    /**
     * kafkaTemplate实现了Kafka发送接收等功能
     *
     * @return
     */
    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate() {
        KafkaTemplate template = new KafkaTemplate(producerFactory());
        return template;
    }

    /**
     * 生产者配置参数
     *
     * @return
     */
    private Map<String, Object> senderProps() {
        Map<String, Object> producer = new HashMap<String, Object>(16);
        //连接地址
        producer.put(ProducerConstant.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //重试，0为不启用重试机制
        producer.put(ProducerConstant.RETRIES_CONFIG, 1);
        //控制批处理大小，单位为字节
        producer.put(ProducerConstant.BATCH_SIZE_CONFIG, 16384);
        //批量发送，延迟为1毫秒，启用该功能能有效减少生产者发送消息次数，从而提高并发量
        producer.put(ProducerConstant.LINGER_MS_CONFIG, 1);
        //生产者可以使用的总内存字节来缓冲等待发送到服务器的记录
        producer.put(ProducerConstant.BUFFER_MEMORY_CONFIG, 1024000);
        //键的序列化方式
        producer.put(ProducerConstant.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        //值的序列化方式
        producer.put(ProducerConstant.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return producer;
    }

    /**
     * 消费者配置参数
     *
     * @return
     */
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<String, Object>(16);
        //连接地址
        props.put(ConsumerConstant.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //GroupID
        props.put(ConsumerConstant.GROUP_ID_CONFIG, "bootKafka");
        //是否自动提交
        props.put(ConsumerConstant.ENABLE_AUTO_COMMIT_CONFIG, true);
        //自动提交的频率
        props.put(ConsumerConstant.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        //Session超时设置
        props.put(ConsumerConstant.SESSION_TIMEOUT_MS_CONFIG, "15000");
        //键的反序列化方式
        props.put(ConsumerConstant.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        //值的反序列化方式
        props.put(ConsumerConstant.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }
}
