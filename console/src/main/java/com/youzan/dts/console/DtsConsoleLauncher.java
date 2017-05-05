package com.youzan.dts.console;

import com.youzan.dts.common.PropertiesManager;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DtsConsoleLauncher {

    private static final Logger LOG = LoggerFactory.getLogger(DtsConsoleLauncher.class);

    public static void main(String[] args) {
        try {
            // 启动配置管理器
            PropertiesManager.start();

            // 启动jetty
            final JettyEmbedServer server = new JettyEmbedServer();
            server.start();

            // 启动监控报警(目前不启动该调度程序，监控信息由运维定时采集)
            // MonitorScheduler monitor = new MonitorScheduler();
            // monitor.start();
            // LOG.info("MonitorScheduler is started.");

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        PropertiesManager.stop();
                        // monitor.stop();
                        server.stop();
                    } catch (Throwable e) {
                        LOG.error("## Something goes wrong when stoping the dts console:\n{}", ExceptionUtils.getFullStackTrace(e));
                    } finally {
                        LOG.info("dts console is stoped.");
                    }
                }
            });
        } catch (Throwable e) {
            LOG.error("## Something goes wrong when starting up the dts console:\n{}", ExceptionUtils.getFullStackTrace(e));
            System.exit(0);
        }
    }

}
