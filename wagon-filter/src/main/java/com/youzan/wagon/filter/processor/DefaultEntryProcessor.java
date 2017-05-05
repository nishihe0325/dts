package com.youzan.wagon.filter.processor;


import com.alibaba.otter.canal.protocol.CanalEntry;
import com.youzan.wagon.common.WagonConstants;
import com.youzan.wagon.common.processor.MQService;
import com.youzan.wagon.common.processor.EntryProcessor;
import com.alibaba.otter.canal.common.utils.PropertiesManager;

import java.util.List;

public class DefaultEntryProcessor implements EntryProcessor {

    private EntryProcessor realProcessor;

    public DefaultEntryProcessor() {
        String processorType = PropertiesManager.get(WagonConstants.PRO_PROCESSOR_TYPE);
        if (WagonConstants.PRO_PROCESSOR_TYPE_LOG.equalsIgnoreCase(processorType)) {
            realProcessor = new LogDirectProcessor();
        } else {
            realProcessor = new MQProcessor();
        }
    }

    @Override
    public boolean process(List<CanalEntry.Entry> entries) {
        return realProcessor.process(entries);
    }

    public void start() throws Throwable {
        realProcessor.start();
    }

    public void stop() throws Throwable {
        realProcessor.stop();
    }

}
