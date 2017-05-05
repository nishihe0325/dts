package com.youzan.wagon.common.processor;

import com.youzan.wagon.common.rule.TopicRule;

public interface MQService {

    boolean put(String message, TopicRule topicRule, Long shardingId);

    boolean put(Object message, TopicRule topicRule, Long shardingId);

    void start() throws Throwable;

    void stop() throws Throwable;

}
