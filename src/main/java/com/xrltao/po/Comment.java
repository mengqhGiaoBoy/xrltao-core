package com.xrltao.po;

/** 评论表
 * @author mengqh
 * @version 1.0
 * @date 2020/1/4 22:41
 * @Description
 */
public class Comment {

  private Integer id;
  private String content;
  private Integer userId;
  private String headImg;
  private String name;
  private Double point;
  private Integer up;
  private java.sql.Timestamp createTime;
  private Integer orderId;
  private Integer videoId;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getHeadImg() {
    return headImg;
  }

  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Double getPoint() {
    return point;
  }

  public void setPoint(double point) {
    this.point = point;
  }


  public Integer getUp() {
    return up;
  }

  public void setUp(Integer up) {
    this.up = up;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }


  public Integer getVideoId() {
    return videoId;
  }

  public void setVideoId(Integer videoId) {
    this.videoId = videoId;
  }

}
