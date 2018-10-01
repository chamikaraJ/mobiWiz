/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.mobiwiz.cwmwsql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.mobiwiz.cwmwsql.Rosterslots;

/**
 * Service object for domain model class {@link Rosterslots}.
 */
public interface RosterslotsService {

    /**
     * Creates a new Rosterslots. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Rosterslots if any.
     *
     * @param rosterslots Details of the Rosterslots to be created; value cannot be null.
     * @return The newly created Rosterslots.
     */
    Rosterslots create(@Valid Rosterslots rosterslots);


	/**
     * Returns Rosterslots by given id if exists.
     *
     * @param rosterslotsId The id of the Rosterslots to get; value cannot be null.
     * @return Rosterslots associated with the given rosterslotsId.
	 * @throws EntityNotFoundException If no Rosterslots is found.
     */
    Rosterslots getById(String rosterslotsId);

    /**
     * Find and return the Rosterslots by given id if exists, returns null otherwise.
     *
     * @param rosterslotsId The id of the Rosterslots to get; value cannot be null.
     * @return Rosterslots associated with the given rosterslotsId.
     */
    Rosterslots findById(String rosterslotsId);

	/**
     * Find and return the list of Rosterslots by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param rosterslotsIds The id's of the Rosterslots to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Rosterslots associated with the given rosterslotsIds.
     */
    List<Rosterslots> findByMultipleIds(List<String> rosterslotsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Rosterslots. It replaces all fields of the existing Rosterslots with the given rosterslots.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Rosterslots if any.
     *
     * @param rosterslots The details of the Rosterslots to be updated; value cannot be null.
     * @return The updated Rosterslots.
     * @throws EntityNotFoundException if no Rosterslots is found with given input.
     */
    Rosterslots update(@Valid Rosterslots rosterslots);

    /**
     * Deletes an existing Rosterslots with the given id.
     *
     * @param rosterslotsId The id of the Rosterslots to be deleted; value cannot be null.
     * @return The deleted Rosterslots.
     * @throws EntityNotFoundException if no Rosterslots found with the given id.
     */
    Rosterslots delete(String rosterslotsId);

    /**
     * Deletes an existing Rosterslots with the given object.
     *
     * @param rosterslots The instance of the Rosterslots to be deleted; value cannot be null.
     */
    void delete(Rosterslots rosterslots);

    /**
     * Find all Rosterslots matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Rosterslots.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Rosterslots> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Rosterslots matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Rosterslots.
     *
     * @see Pageable
     * @see Page
     */
    Page<Rosterslots> findAll(String query, Pageable pageable);

    /**
     * Exports all Rosterslots matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Rosterslots matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the Rosterslots in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Rosterslots.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}