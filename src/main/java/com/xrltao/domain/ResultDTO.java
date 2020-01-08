package com.xrltao.domain;

/** 相应对象
 * @author mengqh
 * @version 1.0
 * @date 2020/1/5 12:39
 * @Description
 */
public class ResultDTO {
    private int status;
    private Object content;
    private String other;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
