/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.ge.predix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ge.predix.model.Client;

//@RepositoryRestResource(collectionResourceRel = "client", path = "clients")
public interface ClientRepository
        extends CrudRepository<Client, Long>
{
    /** * Method that returns a lista of clients doing a search by the passed name parameter. * * @param name * @return list of clients */
    List<Client> findByName(@Param("name") String name);

    /**
     * * Method that returns a client with only its name doing a search by the passed id parameter. * * @param id * @return client of the id passed as
     * parameter.
     */
    @Query("SELECT c.name FROM Client c where c.id = :id")
    Client findNameById(@Param("id") Long id);

    /**
     * * Method that returns a list of clients doing a search by the passed name parameter and sorting them by the name. * * @param name * @return list of
     * clients
     */
    List<Client> findByNameOrderByName(@Param("name") String name);
}
