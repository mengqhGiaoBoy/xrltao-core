package com.xrltao.ex;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/18 18:58
 * @Description
 */
public class XrException extends Exception {
    private int status;
    private String mes;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
