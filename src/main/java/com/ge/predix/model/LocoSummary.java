/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.ge.predix.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author predix -
 */
@Entity
@Table(name = "locosummary")
public class LocoSummary
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * @return the id
     */
    public Long getId()
    {
        return this.id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    @Column(name = "faildate")
    private Date failDate;
    
    @Column(name = "failcount")
    private int  failCount;
    
    /**
     * @return the failDate
     */
    public Date getFailDate()
    {
        return this.failDate;
    }
    /**
     * @param failDate the failDate to set
     */
    public void setFailDate(Date failDate)
    {
        this.failDate = failDate;
    }
    /**
     * @return the failCount
     */
    public int getFailCount()
    {
        return this.failCount;
    }
    /**
     * @param failCount the failCount to set
     */
    public void setFailCount(int failCount)
    {
        this.failCount = failCount;
    }
    

}
