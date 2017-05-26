package com.dodonew.model;

/**
 * Created by yukx on 17/4/13.
 */
public class SM_InterfaceLog {
    private String logTime;
    private String logRequetParam;
    private String logReturnData;
    private String logReturnStatus;
    private String remark;
    private String className;
    private String methodName;
    private Long timeConsume;
    private String devId;

    @Override
    public String toString() {
        return "SM_InterfaceLog{" +
                "logTime='" + logTime + '\'' +
                ", logRequetParam='" + logRequetParam + '\'' +
                ", logReturnData='" + logReturnData + '\'' +
                ", logReturnStatus='" + logReturnStatus + '\'' +
                ", remark='" + remark + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", timeConsume='" + timeConsume + '\'' +
                ", devId='" + devId + '\'' +
                '}';
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogRequetParam() {
        return logRequetParam;
    }

    public void setLogRequetParam(String logRequetParam) {
        this.logRequetParam = logRequetParam;
    }

    public String getLogReturnData() {
        return logReturnData;
    }

    public void setLogReturnData(String logReturnData) {
        this.logReturnData = logReturnData;
    }

    public String getLogReturnStatus() {
        return logReturnStatus;
    }

    public void setLogReturnStatus(String logReturnStatus) {
        this.logReturnStatus = logReturnStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Long getTimeConsume() {
        return timeConsume;
    }

    public void setTimeConsume(Long timeConsume) {
        this.timeConsume = timeConsume;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }
}
