package com.learning.keep.model;

import java.util.Date;

public class Order {
    /**
     * <pre>
     * 备注 : 
     * 表字段 :  tfs_order.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 备注 : 城市ID
     * 表字段 :  tfs_order.city_id
     * </pre>
     */
    private Integer cityId;

    /**
     * <pre>
     * 备注 : 订单中心编号
     * 表字段 :  tfs_order.order_center_no
     * </pre>
     */
    private Long orderCenterNo;

    /**
     * <pre>
     * 备注 : 订单编号
     * 表字段 :  tfs_order.order_no
     * </pre>
     */
    private String orderNo;

    /**
     * <pre>
     * 备注 : tfs_customer.id
     * 表字段 :  tfs_order.customer_id
     * </pre>
     */
    private Integer customerId;

    /**
     * <pre>
     * 备注 : tfs_product.id
     * 表字段 :  tfs_order.product_id
     * </pre>
     */
    private Integer productId;

    /**
     * <pre>
     * 备注 : 流程实例id
     * 表字段 :  tfs_order.process_instance_id
     * </pre>
     */
    private String processInstanceId;

    /**
     * <pre>
     * 备注 : 状态：0-未知
     * 表字段 :  tfs_order.status
     * </pre>
     */
    private Integer status;

    /**
     * <pre>
     * 备注 : 关闭时间
     * 表字段 :  tfs_order.close_time
     * </pre>
     */
    private Date closeTime;

    /**
     * <pre>
     * 备注 : 是否删除：0未删除 1已删除
     * 表字段 :  tfs_order.is_deleted
     * </pre>
     */
    private Byte isDeleted;

    /**
     * <pre>
     * 备注 : 
     * 表字段 :  tfs_order.create_time
     * </pre>
     */
    private Date createTime;

    /**
     * <pre>
     * 备注 : 
     * 表字段 :  tfs_order.update_time
     * </pre>
     */
    private Date updateTime;

    /**
     * <pre>
     * 备注 : 进件时间
     * 表字段 :  tfs_order.entry_time
     * </pre>
     */
    private Date entryTime;

    /**
     * <pre>
     * 备注 : 
     * 表字段 :  tfs_order.sys_time
     * </pre>
     */
    private Date sysTime;

    /**
     * <pre>
     * 备注 : 
     * 表字段 :  tfs_order.delete_time
     * </pre>
     */
    private Date deleteTime;

    /**
     * <pre>
     * 备注 : 导入数据标志 0-否 1-是
     * 表字段 :  tfs_order.import_flag
     * </pre>
     */
    private Byte importFlag;

    /**
     * <pre>
     * 备注 : 导入数据的自有编号
     * 表字段 :  tfs_order.import_no
     * </pre>
     */
    private String importNo;

    /**
     * <pre>
     * 备注 : 资金类型：0-正常融资 1-自有资金 2-临时垫资
     * 表字段 :  tfs_order.fund_type
     * </pre>
     */
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
        this.orderNo = orderNo == null ? null : orderNo.trim();
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
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
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

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
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
        this.importNo = importNo == null ? null : importNo.trim();
    }

    public Byte getFundType() {
        return fundType;
    }

    public void setFundType(Byte fundType) {
        this.fundType = fundType;
    }
}