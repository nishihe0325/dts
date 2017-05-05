package com.alibaba.otter.canal.common.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有canal实例数据集合,即,实例名和CanalInstanceDataV2对象的映射Map。
 * <p>
 * 以下场景会用到该对象:
 * 1, 实例配置监控器定期从console获取最新的实例配置信息时,使用该对象封装信息
 * 2, 定时器定期将运行位点等信息同步给控制台时,使用该对象封装信息
 * <p>
 * Created by wangguofeng on 17/3/14.
 */
public class CanalInstanceWrapperData extends RemotingSerializable {

    private String version;
    private String serviceName;
    private String host;
    private Integer port;

    private Map<String, CanalInstanceDataV2> instanceDatas = new HashMap<String, CanalInstanceDataV2>();

    // ================== constructor ===================
    public CanalInstanceWrapperData() {
    }

    public CanalInstanceWrapperData(String serviceName, String version) {
        this.serviceName = serviceName;
        this.version = version;
    }

    public CanalInstanceWrapperData(String serviceName, String host, Integer port) {
        this.serviceName = serviceName;
        this.host = host;
        this.port = port;
    }

    // ================== operator ===================
    public void addInstanceData(CanalInstanceDataV2 instanceData) {
        instanceDatas.put(instanceData.getInstanceName(), instanceData);
    }

    // ================== setter / getter ===================
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Map<String, CanalInstanceDataV2> getInstanceDatas() {
        return instanceDatas;
    }

    public void setInstanceDatas(Map<String, CanalInstanceDataV2> instanceDatas) {
        this.instanceDatas = instanceDatas;
    }

}
