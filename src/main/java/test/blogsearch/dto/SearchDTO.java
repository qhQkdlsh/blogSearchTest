package test.blogsearch.dto;

import java.net.URLEncoder;

public class SearchDTO {
    private String keyword;
    private String sort;
    private int page;
    private int size;
    private int pageSize;
    private int startPage;
    private int endPage;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = URLEncoder.encode(keyword);
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setPageSize(BlogDTO blog) {
        this.pageSize = blog.getMeta().getTotal_count()/this.size+1;
        this.startPage = this.page < 6 ? 1 : this.page - 5;
        this.endPage = (this.pageSize - this.startPage) < 10 ? this.pageSize : this.startPage + 9;
    }

    public SearchDTO() {
        this.keyword = "";
        this.sort = "accuracy";
        this.page = 1;
        this.size = 10;
        this.pageSize = 10;
    }
}
