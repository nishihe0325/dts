package com.youzan.dts.console;

import com.youzan.dts.common.PropertiesManager;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jetty服务类
 *
 * @author wangguofeng since 2016年3月9日 下午2:40:24
 */
public class JettyEmbedServer {

    private static final Logger LOG = LoggerFactory.getLogger(JettyEmbedServer.class);
    private Server server;
    private int port;
    private String webappPath;

    public JettyEmbedServer() {
        port = PropertiesManager.getInteger("dts.console.webapp.port");
        webappPath = PropertiesManager.getProperty("dts.console.webapp.path");
    }

    public void start() throws Exception {
        WebAppContext webContext = new WebAppContext(webappPath, "/");
        webContext.setDescriptor(webappPath + "/WEB-INF/web.xml");
        webContext.setResourceBase(webappPath);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());

        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        connector.setReuseAddress(true);

        server.setConnectors(new Connector[]{connector});
        server.setStopAtShutdown(true);
        server.setHandler(webContext);

        server.start();
        LOG.info("JettyEmbedServer is started.");
    }

    public void join() throws Exception {
        server.join();
        LOG.info("JettyEmbedServer is joined.");
    }

    public void stop() throws Exception {
        server.stop();
        LOG.info("JettyEmbedServer is stoped.");
    }

}
