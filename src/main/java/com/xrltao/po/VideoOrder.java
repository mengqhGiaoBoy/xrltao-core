package com.xrltao.po;

/**
 * 订单类
 * @author mengqh
 * @version 1.0
 * @date 2020/1/4 22:41
 * @Description
 */
public class VideoOrder<a> {

  private Integer id;
  private String openid;
  private String outTradeNo;
  private Integer state; // 支付状态 0：表示未支付，1：表示已支付
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp notifyTime;
  private Integer totalFee; // 分为单位
  private String nickname;
  private String headImg;
  private Integer videoId; // 视频ID
  private String videoTitle; // 视频图片
  private String videoImg; // 视频图片
  private Integer userId; // 用户ID
  private String ip; // 用户IP
  private Integer del;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }


  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }


  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getNotifyTime() {
    return notifyTime;
  }

  public void setNotifyTime(java.sql.Timestamp notifyTime) {
    this.notifyTime = notifyTime;
  }


  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getHeadImg() {
    return headImg;
  }

  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }


  public Integer getVideoId() {
    return videoId;
  }

  public void setVideoId(Integer videoId) {
    this.videoId = videoId;
  }


  public String getVideoTitle() {
    return videoTitle;
  }

  public void setVideoTitle(String videoTitle) {
    this.videoTitle = videoTitle;
  }


  public String getVideoImg() {
    return videoImg;
  }

  public void setVideoImg(String videoImg) {
    this.videoImg = videoImg;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public Integer getDel() {
    return del;
  }

  public void setDel(Integer del) {
    this.del = del;
  }

}
