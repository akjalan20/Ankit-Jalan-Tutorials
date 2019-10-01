package com.apjschool.librarymgmt.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchFilterRequest {

	@JsonProperty("SearchFilter")
	@JsonInclude(value = Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
    private List<SearchFilter> searchFilter;
    private Integer maxMonthsExpiration;

    public List<SearchFilter> getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(List<SearchFilter> searchFilters) {
        this.searchFilter = searchFilters;
    }

    public Integer getMaxMonthsExpiration() {
        return maxMonthsExpiration;
    }

    public void setMaxMonthsExpiration(Integer maxExpirationMonths) {
        this.maxMonthsExpiration = maxExpirationMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchFilterRequest that = (SearchFilterRequest) o;

        if (!searchFilter.equals(that.searchFilter)) return false;
        return maxMonthsExpiration.equals(that.maxMonthsExpiration);
    }

    @Override
    public int hashCode() {
        int result = searchFilter.hashCode();
        result = 31 * result + maxMonthsExpiration.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SearchFilterRequest{" +
                "searchFilter=" + searchFilter +
                ", maxMonthsExpiration=" + maxMonthsExpiration +
                '}';
    }



}
