package com.apjschool.librarymgmt.dto;

import java.util.List;

public class SearchFilterRequest {

    private List<SearchFilter> searchFilters;
    private Integer maxMonthsExpiration;

    public List<SearchFilter> getSearchFilter() {
        return searchFilters;
    }

    public void setSearchFilter(List<SearchFilter> searchFilters) {
        this.searchFilters = searchFilters;
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

        if (!searchFilters.equals(that.searchFilters)) return false;
        return maxMonthsExpiration.equals(that.maxMonthsExpiration);
    }

    @Override
    public int hashCode() {
        int result = searchFilters.hashCode();
        result = 31 * result + maxMonthsExpiration.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SearchFilterRequest{" +
                "searchFilter=" + searchFilters +
                ", maxMonthsExpiration=" + maxMonthsExpiration +
                '}';
    }



}
