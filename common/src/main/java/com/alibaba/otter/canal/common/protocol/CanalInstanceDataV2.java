package com.alibaba.otter.canal.common.protocol;

/**
 * Created by wangguofeng on 17/3/14.
 */
public class CanalInstanceDataV2 extends RemotingSerializable {
    private String instanceName;

    // mysql信息
    private String dbHost;
    private int dbPort;
    private String dbUsername;
    private String dbPassword;
    private long slaveId = 1234;

    // binlog信息
    private String binlogFile;
    private Long binlogOffset;
    private Long binlogExeTime;

    // ================== setter / getter ===================
    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public int getDbPort() {
        return dbPort;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public long getSlaveId() {
        return slaveId;
    }

    public void setSlaveId(long slaveId) {
        this.slaveId = slaveId;
    }

    public String getBinlogFile() {
        return binlogFile;
    }

    public void setBinlogFile(String binlogFile) {
        this.binlogFile = binlogFile;
    }

    public Long getBinlogOffset() {
        return binlogOffset;
    }

    public void setBinlogOffset(Long binlogOffset) {
        this.binlogOffset = binlogOffset;
    }

    public Long getBinlogExeTime() {
        return binlogExeTime;
    }

    public void setBinlogExeTime(Long binlogExeTime) {
        this.binlogExeTime = binlogExeTime;
    }

}