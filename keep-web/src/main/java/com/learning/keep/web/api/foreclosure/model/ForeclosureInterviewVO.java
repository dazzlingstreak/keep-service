package com.learning.keep.web.api.foreclosure.model;

import java.util.Date;

public class ForeclosureInterviewVO {
    /**
     * <pre>
     * 备注 : 主键ID
     * 表字段 :  tfs_foreclosure_interview.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 备注 : 订单id
     * 表字段 :  tfs_foreclosure_interview.order_id
     * </pre>
     */
    private Integer orderId;

    /**
     * <pre>
     * 备注 : 面签结果:0-不通过 1-通过
     * 表字段 :  tfs_foreclosure_interview.interview_result
     * </pre>
     */
    private Byte interviewResult;

    /**
     * <pre>
     * 备注 : 备注
     * 表字段 :  tfs_foreclosure_interview.interview_remark
     * </pre>
     */
    private String interviewRemark;

    /**
     * <pre>
     * 备注 : 面签的其它情况说明
     * 表字段 :  tfs_foreclosure_interview.other_instructions
     * </pre>
     */
    private String otherInstructions;

    /**
     * <pre>
     * 备注 : 签约视频材料组id
     * 表字段 :  tfs_foreclosure_interview.sign_link_groupId
     * </pre>
     */
    private Integer signLinkGroupid;

    /**
     * <pre>
     * 备注 : 银行放款承诺通知书视频链接
     * 表字段 :  tfs_foreclosure_interview.bank_promise_link_groupId
     * </pre>
     */
    private Integer bankPromiseLinkGroupid;

    /**
     * <pre>
     * 备注 : 面签材料组id
     * 表字段 :  tfs_foreclosure_interview.interview_materials_groupId
     * </pre>
     */
    private Integer interviewMaterialsGroupid;

    /**
     * <pre>
     * 备注 : 赎楼材料组id
     * 表字段 :  tfs_foreclosure_interview.foreclosure_materials_groupId
     * </pre>
     */
    private Integer foreclosureMaterialsGroupid;

    /**
     * <pre>
     * 备注 : 创建时间
     * 表字段 :  tfs_foreclosure_interview.create_time
     * </pre>
     */
    private Date createTime;

    /**
     * <pre>
     * 备注 : 更新时间
     * 表字段 :  tfs_foreclosure_interview.update_time
     * </pre>
     */
    private Date updateTime;

    /**
     * <pre>
     * 备注 : 数据维护时间
     * 表字段 :  tfs_foreclosure_interview.sys_time
     * </pre>
     */
    private Date sysTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Byte getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(Byte interviewResult) {
        this.interviewResult = interviewResult;
    }

    public String getInterviewRemark() {
        return interviewRemark;
    }

    public void setInterviewRemark(String interviewRemark) {
        this.interviewRemark = interviewRemark == null ? null : interviewRemark.trim();
    }

    public String getOtherInstructions() {
        return otherInstructions;
    }

    public void setOtherInstructions(String otherInstructions) {
        this.otherInstructions = otherInstructions == null ? null : otherInstructions.trim();
    }

    public Integer getSignLinkGroupid() {
        return signLinkGroupid;
    }

    public void setSignLinkGroupid(Integer signLinkGroupid) {
        this.signLinkGroupid = signLinkGroupid;
    }

    public Integer getBankPromiseLinkGroupid() {
        return bankPromiseLinkGroupid;
    }

    public void setBankPromiseLinkGroupid(Integer bankPromiseLinkGroupid) {
        this.bankPromiseLinkGroupid = bankPromiseLinkGroupid;
    }

    public Integer getInterviewMaterialsGroupid() {
        return interviewMaterialsGroupid;
    }

    public void setInterviewMaterialsGroupid(Integer interviewMaterialsGroupid) {
        this.interviewMaterialsGroupid = interviewMaterialsGroupid;
    }

    public Integer getForeclosureMaterialsGroupid() {
        return foreclosureMaterialsGroupid;
    }

    public void setForeclosureMaterialsGroupid(Integer foreclosureMaterialsGroupid) {
        this.foreclosureMaterialsGroupid = foreclosureMaterialsGroupid;
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

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }
}