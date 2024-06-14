package com.ohgiraffers.test2.car.model.dto;


import java.time.LocalDateTime;

public class MemberDTO {

    private String memberId;
    public String memberPwd;
    public String memberName;
    public String phone;
    public String address;
    public LocalDateTime enrollDate;
    public String memberRoll;
    public String status;

    public MemberDTO() {
    }

    public MemberDTO(String memberId, String memberPwd, String memberName, String phone, String address, LocalDateTime enrollDate, String memberRoll, String status) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRoll = memberRoll;
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDateTime enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getMemberRoll() {
        return memberRoll;
    }

    public void setMemberRoll(String memberRoll) {
        this.memberRoll = memberRoll;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRoll=" + memberRoll +
                ", status='" + status + '\'' +
                '}';
    }
}
