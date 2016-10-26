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
@Table(name = "test")
public class Test
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long           id;
    private Long           age;
    private String         name;
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
    /**
     * @return the age
     */
    public Long getAge()
    {
        return this.age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(Long age)
    {
        this.age = age;
    }
    /**
     * @return the name
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
