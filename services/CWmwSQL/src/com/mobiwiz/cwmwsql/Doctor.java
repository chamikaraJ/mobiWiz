/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.mobiwiz.cwmwsql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Doctor generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`doctor`")
public class Doctor implements Serializable {

    private String doctorId;
    private int idNo;
    private String providerno;
    private String accountno;
    private String title;
    private String given;
    private String surname;
    private String address1;
    private String address2;
    private String suburb;
    private String postcode;
    private String state;
    private String qualifictn;
    private String phoneAh;
    private String phoneBh;
    private String fax;
    private String mobile;
    private String paging;
    private String practicenm;
    private short usualdurtn = 0;
    private String schedlrId;
    private String resorceId;
    private boolean canDblbuk;
    private String specialty1;
    private String specialty2;
    private String type;
    private String wpletrhead;
    private boolean usewordpro;
    private boolean dobulkbill;
    private float sortorder = 0F;
    private boolean nowIn;
    private short usualtimes = 0;
    private short usualstrtt = 0;
    private short usualendt = 0;
    private String rsrctype;
    private boolean onlyincaln;
    private String email;
    private String prscribrno;
    private String hiccustno;
    private boolean hicmandsig;
    private boolean hicagrsgnd;
    private boolean hicpatclok;
    private boolean hicsendok;
    private boolean hicnosgnsc;
    private String mid;
    private String mbrnno;
    private LocalDateTime mbrnexdt;

    @Id
    @Column(name = "`doctor_id`", nullable = false, length = 10)
    public String getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Column(name = "`IdNo`", nullable = false, scale = 0, precision = 10)
    public int getIdNo() {
        return this.idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    @Column(name = "`providerno`", nullable = false, length = 14)
    public String getProviderno() {
        return this.providerno;
    }

    public void setProviderno(String providerno) {
        this.providerno = providerno;
    }

    @Column(name = "`accountno`", nullable = false, length = 10)
    public String getAccountno() {
        return this.accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    @Column(name = "`title`", nullable = false, length = 5)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "`given`", nullable = false, length = 15)
    public String getGiven() {
        return this.given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    @Column(name = "`surname`", nullable = false, length = 25)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "`address1`", nullable = false, length = 30)
    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "`address2`", nullable = false, length = 20)
    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Column(name = "`suburb`", nullable = false, length = 20)
    public String getSuburb() {
        return this.suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Column(name = "`postcode`", nullable = false, length = 4)
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name = "`state`", nullable = false, length = 3)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "`qualifictn`", nullable = false, length = 60)
    public String getQualifictn() {
        return this.qualifictn;
    }

    public void setQualifictn(String qualifictn) {
        this.qualifictn = qualifictn;
    }

    @Column(name = "`phone_ah`", nullable = false, length = 14)
    public String getPhoneAh() {
        return this.phoneAh;
    }

    public void setPhoneAh(String phoneAh) {
        this.phoneAh = phoneAh;
    }

    @Column(name = "`phone_bh`", nullable = false, length = 14)
    public String getPhoneBh() {
        return this.phoneBh;
    }

    public void setPhoneBh(String phoneBh) {
        this.phoneBh = phoneBh;
    }

    @Column(name = "`fax`", nullable = false, length = 14)
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "`mobile`", nullable = false, length = 14)
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "`paging`", nullable = false, length = 25)
    public String getPaging() {
        return this.paging;
    }

    public void setPaging(String paging) {
        this.paging = paging;
    }

    @Column(name = "`practicenm`", nullable = false, length = 30)
    public String getPracticenm() {
        return this.practicenm;
    }

    public void setPracticenm(String practicenm) {
        this.practicenm = practicenm;
    }

    @Column(name = "`usualdurtn`", nullable = false, scale = 0, precision = 3)
    public short getUsualdurtn() {
        return this.usualdurtn;
    }

    public void setUsualdurtn(short usualdurtn) {
        this.usualdurtn = usualdurtn;
    }

    @Column(name = "`schedlr_id`", nullable = false, length = 2)
    public String getSchedlrId() {
        return this.schedlrId;
    }

    public void setSchedlrId(String schedlrId) {
        this.schedlrId = schedlrId;
    }

    @Column(name = "`resorce_id`", nullable = false, length = 10)
    public String getResorceId() {
        return this.resorceId;
    }

    public void setResorceId(String resorceId) {
        this.resorceId = resorceId;
    }

    @Column(name = "`can_dblbuk`", nullable = false)
    public boolean isCanDblbuk() {
        return this.canDblbuk;
    }

    public void setCanDblbuk(boolean canDblbuk) {
        this.canDblbuk = canDblbuk;
    }

    @Column(name = "`specialty1`", nullable = false, length = 25)
    public String getSpecialty1() {
        return this.specialty1;
    }

    public void setSpecialty1(String specialty1) {
        this.specialty1 = specialty1;
    }

    @Column(name = "`specialty2`", nullable = false, length = 25)
    public String getSpecialty2() {
        return this.specialty2;
    }

    public void setSpecialty2(String specialty2) {
        this.specialty2 = specialty2;
    }

    @Column(name = "`type`", nullable = false, length = 10)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "`wpletrhead`", nullable = false, length = 25)
    public String getWpletrhead() {
        return this.wpletrhead;
    }

    public void setWpletrhead(String wpletrhead) {
        this.wpletrhead = wpletrhead;
    }

    @Column(name = "`usewordpro`", nullable = false)
    public boolean isUsewordpro() {
        return this.usewordpro;
    }

    public void setUsewordpro(boolean usewordpro) {
        this.usewordpro = usewordpro;
    }

    @Column(name = "`dobulkbill`", nullable = false)
    public boolean isDobulkbill() {
        return this.dobulkbill;
    }

    public void setDobulkbill(boolean dobulkbill) {
        this.dobulkbill = dobulkbill;
    }

    @Column(name = "`sortorder`", nullable = false, scale = 1, precision = 3)
    public float getSortorder() {
        return this.sortorder;
    }

    public void setSortorder(float sortorder) {
        this.sortorder = sortorder;
    }

    @Column(name = "`now_in`", nullable = false)
    public boolean isNowIn() {
        return this.nowIn;
    }

    public void setNowIn(boolean nowIn) {
        this.nowIn = nowIn;
    }

    @Column(name = "`usualtimes`", nullable = false, scale = 0, precision = 3)
    public short getUsualtimes() {
        return this.usualtimes;
    }

    public void setUsualtimes(short usualtimes) {
        this.usualtimes = usualtimes;
    }

    @Column(name = "`usualstrtt`", nullable = false, scale = 0, precision = 5)
    public short getUsualstrtt() {
        return this.usualstrtt;
    }

    public void setUsualstrtt(short usualstrtt) {
        this.usualstrtt = usualstrtt;
    }

    @Column(name = "`usualendt`", nullable = false, scale = 0, precision = 5)
    public short getUsualendt() {
        return this.usualendt;
    }

    public void setUsualendt(short usualendt) {
        this.usualendt = usualendt;
    }

    @Column(name = "`rsrctype`", nullable = false, length = 10)
    public String getRsrctype() {
        return this.rsrctype;
    }

    public void setRsrctype(String rsrctype) {
        this.rsrctype = rsrctype;
    }

    @Column(name = "`onlyincaln`", nullable = false)
    public boolean isOnlyincaln() {
        return this.onlyincaln;
    }

    public void setOnlyincaln(boolean onlyincaln) {
        this.onlyincaln = onlyincaln;
    }

    @Column(name = "`email`", nullable = false, length = 49)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`prscribrno`", nullable = false, length = 10)
    public String getPrscribrno() {
        return this.prscribrno;
    }

    public void setPrscribrno(String prscribrno) {
        this.prscribrno = prscribrno;
    }

    @Column(name = "`hiccustno`", nullable = false, length = 10)
    public String getHiccustno() {
        return this.hiccustno;
    }

    public void setHiccustno(String hiccustno) {
        this.hiccustno = hiccustno;
    }

    @Column(name = "`hicmandsig`", nullable = false)
    public boolean isHicmandsig() {
        return this.hicmandsig;
    }

    public void setHicmandsig(boolean hicmandsig) {
        this.hicmandsig = hicmandsig;
    }

    @Column(name = "`hicagrsgnd`", nullable = false)
    public boolean isHicagrsgnd() {
        return this.hicagrsgnd;
    }

    public void setHicagrsgnd(boolean hicagrsgnd) {
        this.hicagrsgnd = hicagrsgnd;
    }

    @Column(name = "`hicpatclok`", nullable = false)
    public boolean isHicpatclok() {
        return this.hicpatclok;
    }

    public void setHicpatclok(boolean hicpatclok) {
        this.hicpatclok = hicpatclok;
    }

    @Column(name = "`hicsendok`", nullable = false)
    public boolean isHicsendok() {
        return this.hicsendok;
    }

    public void setHicsendok(boolean hicsendok) {
        this.hicsendok = hicsendok;
    }

    @Column(name = "`hicnosgnsc`", nullable = false)
    public boolean isHicnosgnsc() {
        return this.hicnosgnsc;
    }

    public void setHicnosgnsc(boolean hicnosgnsc) {
        this.hicnosgnsc = hicnosgnsc;
    }

    @Column(name = "`mid`", nullable = false, length = 10)
    public String getMid() {
        return this.mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Column(name = "`mbrnno`", nullable = false, length = 10)
    public String getMbrnno() {
        return this.mbrnno;
    }

    public void setMbrnno(String mbrnno) {
        this.mbrnno = mbrnno;
    }

    @Column(name = "`mbrnexdt`", nullable = false)
    public LocalDateTime getMbrnexdt() {
        return this.mbrnexdt;
    }

    public void setMbrnexdt(LocalDateTime mbrnexdt) {
        this.mbrnexdt = mbrnexdt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        final Doctor doctor = (Doctor) o;
        return Objects.equals(getDoctorId(), doctor.getDoctorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctorId());
    }
}