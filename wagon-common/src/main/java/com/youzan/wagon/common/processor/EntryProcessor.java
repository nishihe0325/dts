package com.youzan.wagon.common.processor;

import java.util.List;

import com.alibaba.otter.canal.protocol.CanalEntry.Entry;

public interface EntryProcessor {

    boolean process(List<Entry> entries);

    void start() throws Throwable;

    void stop() throws Throwable;

}
