package com.userservice.dto;

import java.util.List;

public class PostResponse {
    private List<UserDto> content;
    private int totalPages;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private boolean isLastPage;

    public PostResponse(List<UserDto> content, int totalPages, int pageNo, int pageSize, long totalElements, boolean isLastPage) {
        this.content = content;
        this.totalPages = totalPages;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.isLastPage = isLastPage;
    }
    public PostResponse(){

    }

    public List<UserDto> getContent() {
        return content;
    }

    public void setContent(List<UserDto> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }
}