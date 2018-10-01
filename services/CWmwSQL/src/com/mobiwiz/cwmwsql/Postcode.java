/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.mobiwiz.cwmwsql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Postcode generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`postcode`")
@IdClass(PostcodeId.class)
public class Postcode implements Serializable {

    private String areaname;
    private String postcode;
    private String state;
    private int idNo;
    private String areastate;
    private String sla1;

    @Id
    @Column(name = "`areaname`", nullable = false, length = 20)
    public String getAreaname() {
        return this.areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    @Id
    @Column(name = "`postcode`", nullable = false, length = 4)
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Id
    @Column(name = "`state`", nullable = false, length = 3)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "`IdNo`", nullable = false, scale = 0, precision = 10)
    public int getIdNo() {
        return this.idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    @Column(name = "`areastate`", nullable = false, length = 3)
    public String getAreastate() {
        return this.areastate;
    }

    public void setAreastate(String areastate) {
        this.areastate = areastate;
    }

    @Column(name = "`sla1`", nullable = false, length = 5)
    public String getSla1() {
        return this.sla1;
    }

    public void setSla1(String sla1) {
        this.sla1 = sla1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postcode)) return false;
        final Postcode postcodeInstance = (Postcode) o;
        return Objects.equals(getAreaname(), postcodeInstance.getAreaname()) &&
                Objects.equals(getPostcode(), postcodeInstance.getPostcode()) &&
                Objects.equals(getState(), postcodeInstance.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAreaname(),
                getPostcode(),
                getState());
    }
}