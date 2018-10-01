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
 * Refdoct generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`refdoct`")
public class Refdoct implements Serializable {

    private String refdocId;
    private int idNo;
    private String providerno;
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
    private String hobbies;
    private LocalDateTime dob;
    private LocalDateTime aniversary;
    private String comments;
    private String practicenm;
    private String practicecd;
    private String speciality;
    private boolean invaliddoc;
    private String email;
    private String salutation;
    private String prfcomunic;
    private boolean ok2email;
    private LocalDateTime firstref;
    private String fstcntctby;
    private LocalDateTime fstcntcton;
    private String lstcntctby;
    private LocalDateTime lstcntcton;
    private String spclrequst;
    private short reflperiod = 0;
    private LocalDateTime addedon;
    private boolean inmaillist;
    private String website;
    private String maindoctcd;
    private boolean noautoupdt;
    private boolean isamedcent;
    private String prsnlemail;
    private String adinlemail;
    private String prefemail;
    private boolean rtfpitpls;
    private String prefdfmt;
    private String prefdoc;
    private boolean usepoAdd;
    private String paddress1;
    private String paddress2;
    private String psuburb;
    private String pstate;
    private String ppostcode;

    @Id
    @Column(name = "`refdoc_id`", nullable = false, length = 10)
    public String getRefdocId() {
        return this.refdocId;
    }

    public void setRefdocId(String refdocId) {
        this.refdocId = refdocId;
    }

    @Column(name = "`IdNo`", nullable = false, scale = 0, precision = 10)
    public int getIdNo() {
        return this.idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    @Column(name = "`providerno`", nullable = false, length = 10)
    public String getProviderno() {
        return this.providerno;
    }

    public void setProviderno(String providerno) {
        this.providerno = providerno;
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

    @Column(name = "`surname`", nullable = false, length = 20)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "`address1`", nullable = false, length = 60)
    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "`address2`", nullable = false, length = 30)
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

    @Column(name = "`qualifictn`", nullable = false, length = 25)
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

    @Column(name = "`hobbies`", nullable = false, length = 75)
    public String getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Column(name = "`dob`", nullable = false)
    public LocalDateTime getDob() {
        return this.dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    @Column(name = "`aniversary`", nullable = false)
    public LocalDateTime getAniversary() {
        return this.aniversary;
    }

    public void setAniversary(LocalDateTime aniversary) {
        this.aniversary = aniversary;
    }

    @Column(name = "`comments`", nullable = false, length = 2147483647)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "`practicenm`", nullable = false, length = 75)
    public String getPracticenm() {
        return this.practicenm;
    }

    public void setPracticenm(String practicenm) {
        this.practicenm = practicenm;
    }

    @Column(name = "`practicecd`", nullable = false, length = 10)
    public String getPracticecd() {
        return this.practicecd;
    }

    public void setPracticecd(String practicecd) {
        this.practicecd = practicecd;
    }

    @Column(name = "`speciality`", nullable = false, length = 60)
    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Column(name = "`invaliddoc`", nullable = false)
    public boolean isInvaliddoc() {
        return this.invaliddoc;
    }

    public void setInvaliddoc(boolean invaliddoc) {
        this.invaliddoc = invaliddoc;
    }

    @Column(name = "`email`", nullable = false, length = 49)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`salutation`", nullable = false, length = 40)
    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @Column(name = "`prfcomunic`", nullable = false, length = 10)
    public String getPrfcomunic() {
        return this.prfcomunic;
    }

    public void setPrfcomunic(String prfcomunic) {
        this.prfcomunic = prfcomunic;
    }

    @Column(name = "`ok2email`", nullable = false)
    public boolean isOk2email() {
        return this.ok2email;
    }

    public void setOk2email(boolean ok2email) {
        this.ok2email = ok2email;
    }

    @Column(name = "`firstref`", nullable = false)
    public LocalDateTime getFirstref() {
        return this.firstref;
    }

    public void setFirstref(LocalDateTime firstref) {
        this.firstref = firstref;
    }

    @Column(name = "`fstcntctby`", nullable = false, length = 10)
    public String getFstcntctby() {
        return this.fstcntctby;
    }

    public void setFstcntctby(String fstcntctby) {
        this.fstcntctby = fstcntctby;
    }

    @Column(name = "`fstcntcton`", nullable = false)
    public LocalDateTime getFstcntcton() {
        return this.fstcntcton;
    }

    public void setFstcntcton(LocalDateTime fstcntcton) {
        this.fstcntcton = fstcntcton;
    }

    @Column(name = "`lstcntctby`", nullable = false, length = 10)
    public String getLstcntctby() {
        return this.lstcntctby;
    }

    public void setLstcntctby(String lstcntctby) {
        this.lstcntctby = lstcntctby;
    }

    @Column(name = "`lstcntcton`", nullable = false)
    public LocalDateTime getLstcntcton() {
        return this.lstcntcton;
    }

    public void setLstcntcton(LocalDateTime lstcntcton) {
        this.lstcntcton = lstcntcton;
    }

    @Column(name = "`spclrequst`", nullable = false, length = 2147483647)
    public String getSpclrequst() {
        return this.spclrequst;
    }

    public void setSpclrequst(String spclrequst) {
        this.spclrequst = spclrequst;
    }

    @Column(name = "`reflperiod`", nullable = false, scale = 0, precision = 3)
    public short getReflperiod() {
        return this.reflperiod;
    }

    public void setReflperiod(short reflperiod) {
        this.reflperiod = reflperiod;
    }

    @Column(name = "`addedon`", nullable = false)
    public LocalDateTime getAddedon() {
        return this.addedon;
    }

    public void setAddedon(LocalDateTime addedon) {
        this.addedon = addedon;
    }

    @Column(name = "`inmaillist`", nullable = false)
    public boolean isInmaillist() {
        return this.inmaillist;
    }

    public void setInmaillist(boolean inmaillist) {
        this.inmaillist = inmaillist;
    }

    @Column(name = "`website`", nullable = false, length = 2147483647)
    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Column(name = "`maindoctcd`", nullable = false, length = 10)
    public String getMaindoctcd() {
        return this.maindoctcd;
    }

    public void setMaindoctcd(String maindoctcd) {
        this.maindoctcd = maindoctcd;
    }

    @Column(name = "`noautoupdt`", nullable = false)
    public boolean isNoautoupdt() {
        return this.noautoupdt;
    }

    public void setNoautoupdt(boolean noautoupdt) {
        this.noautoupdt = noautoupdt;
    }

    @Column(name = "`isamedcent`", nullable = false)
    public boolean isIsamedcent() {
        return this.isamedcent;
    }

    public void setIsamedcent(boolean isamedcent) {
        this.isamedcent = isamedcent;
    }

    @Column(name = "`prsnlemail`", nullable = false, length = 90)
    public String getPrsnlemail() {
        return this.prsnlemail;
    }

    public void setPrsnlemail(String prsnlemail) {
        this.prsnlemail = prsnlemail;
    }

    @Column(name = "`adinlemail`", nullable = false, length = 90)
    public String getAdinlemail() {
        return this.adinlemail;
    }

    public void setAdinlemail(String adinlemail) {
        this.adinlemail = adinlemail;
    }

    @Column(name = "`prefemail`", nullable = false, length = 10)
    public String getPrefemail() {
        return this.prefemail;
    }

    public void setPrefemail(String prefemail) {
        this.prefemail = prefemail;
    }

    @Column(name = "`rtfpitpls`", nullable = false)
    public boolean isRtfpitpls() {
        return this.rtfpitpls;
    }

    public void setRtfpitpls(boolean rtfpitpls) {
        this.rtfpitpls = rtfpitpls;
    }

    @Column(name = "`prefdfmt`", nullable = false, length = 10)
    public String getPrefdfmt() {
        return this.prefdfmt;
    }

    public void setPrefdfmt(String prefdfmt) {
        this.prefdfmt = prefdfmt;
    }

    @Column(name = "`prefdoc`", nullable = false, length = 10)
    public String getPrefdoc() {
        return this.prefdoc;
    }

    public void setPrefdoc(String prefdoc) {
        this.prefdoc = prefdoc;
    }

    @Column(name = "`UsepoAdd`", nullable = false)
    public boolean isUsepoAdd() {
        return this.usepoAdd;
    }

    public void setUsepoAdd(boolean usepoAdd) {
        this.usepoAdd = usepoAdd;
    }

    @Column(name = "`P_Address1`", nullable = false, length = 60)
    public String getPaddress1() {
        return this.paddress1;
    }

    public void setPaddress1(String paddress1) {
        this.paddress1 = paddress1;
    }

    @Column(name = "`P_Address2`", nullable = false, length = 30)
    public String getPaddress2() {
        return this.paddress2;
    }

    public void setPaddress2(String paddress2) {
        this.paddress2 = paddress2;
    }

    @Column(name = "`P_Suburb`", nullable = false, length = 20)
    public String getPsuburb() {
        return this.psuburb;
    }

    public void setPsuburb(String psuburb) {
        this.psuburb = psuburb;
    }

    @Column(name = "`P_State`", nullable = false, length = 3)
    public String getPstate() {
        return this.pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    @Column(name = "`P_postcode`", nullable = false, length = 4)
    public String getPpostcode() {
        return this.ppostcode;
    }

    public void setPpostcode(String ppostcode) {
        this.ppostcode = ppostcode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Refdoct)) return false;
        final Refdoct refdoct = (Refdoct) o;
        return Objects.equals(getRefdocId(), refdoct.getRefdocId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRefdocId());
    }
}