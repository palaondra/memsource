package com.pala.memsource.memsource.client.domain;

import java.math.BigDecimal;
import java.util.List;

public class MemSourceListOfProjectResponse {
    
    public BigDecimal getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(BigDecimal totalElements) {
        this.totalElements = totalElements;
    }

    public BigDecimal getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(BigDecimal totalPages) {
        this.totalPages = totalPages;
    }

    public BigDecimal getPageSize() {
        return pageSize;
    }

    public void setPageSize(BigDecimal pageSize) {
        this.pageSize = pageSize;
    }

    public BigDecimal getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(BigDecimal pageNumber) {
        this.pageNumber = pageNumber;
    }

    public BigDecimal getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(BigDecimal numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public List<MemSourceProject> getContent() {
        return content;
    }

    public void setContent(List<MemSourceProject> content) {
        this.content = content;
    }

    private BigDecimal totalElements;
    
    private BigDecimal totalPages;
    
    private BigDecimal pageSize;

    private BigDecimal pageNumber;

    private BigDecimal numberOfElements;

    private List<MemSourceProject> content;

    public MemSourceListOfProjectResponse() { }

    
}
