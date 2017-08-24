package com.learning.keep.web.api.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by huangdawei on 2017/8/24.
 */
public class OrderVO {

    @ApiModelProperty("订单id")
    private Integer id;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("订单中心编号")
    private Long orderCenterNo;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("客户id")
    private Integer customerId;

    @ApiModelProperty("产品id")
    private Integer productId;

    @ApiModelProperty("流程实例id")
    private String processInstanceId;

    @ApiModelProperty("流程所处状态")
    private Integer status;

    @ApiModelProperty("关闭时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date closeTime;

    @ApiModelProperty("是否删除")
    private Byte isDeleted;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    @ApiModelProperty("进件时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date entryTime;

    @ApiModelProperty("删除时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deleteTime;

    @ApiModelProperty("导入标志")
    private Byte importFlag;

    @ApiModelProperty("导入编号")
    private String importNo;

    @ApiModelProperty("资金类型")
    private Byte fundType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Long getOrderCenterNo() {
        return orderCenterNo;
    }

    public void setOrderCenterNo(Long orderCenterNo) {
        this.orderCenterNo = orderCenterNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Byte getImportFlag() {
        return importFlag;
    }

    public void setImportFlag(Byte importFlag) {
        this.importFlag = importFlag;
    }

    public String getImportNo() {
        return importNo;
    }

    public void setImportNo(String importNo) {
        this.importNo = importNo;
    }

    public Byte getFundType() {
        return fundType;
    }

    public void setFundType(Byte fundType) {
        this.fundType = fundType;
    }
}
