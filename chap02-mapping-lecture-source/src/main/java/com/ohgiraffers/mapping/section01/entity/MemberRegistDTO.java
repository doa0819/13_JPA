package com.ohgiraffers.mapping.section01.entity;

import java.time.LocalDateTime;

public class MemberRegistDTO {

    // 엔티티로 가기전 값을 담는 공간 -> service 나 controller 로 보내주기 위해
    // date 단위들을 원래 controller 에서 수정 했었는데 그거를 엔티티에다가 넣어 줄수 있음

    private String memberId;
    public String memberPwd;
    public String memberName;
    public String phone;
    public String address;
    public LocalDateTime enrollDate;
    public MemberRole memberRoll;
    public String status;

    public MemberRegistDTO() {
    }

    public MemberRegistDTO(String memberId, String memberPwd, String memberName, String phone, String address, LocalDateTime enrollDate, MemberRole memberRoll, String status) {
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

    public MemberRole getMemberRoll() {
        return memberRoll;
    }

    public void setMemberRoll(MemberRole memberRoll) {
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
        return "MemberRegistDTO{" +
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
