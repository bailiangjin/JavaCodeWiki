package com.blj.javawiki.demo.reconnectquen;

public class ReconnectItem {
    private long orgRequestTime;
    private long timeout;

    public ReconnectItem(long orgRequestTime, long timeout) {
        this.orgRequestTime = orgRequestTime;
        this.timeout = timeout;
    }

    public long getOrgRequestTime() {
        return orgRequestTime;
    }

    public void setOrgRequestTime(long orgRequestTime) {
        this.orgRequestTime = orgRequestTime;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
