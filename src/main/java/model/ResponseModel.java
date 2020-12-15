package model;

import java.util.List;

public class ResponseModel {
    private List<Object> items;
    private Integer found;
    private Integer pages;
    private Integer per_page;
    private Integer page;
    private Object clusters;
    private Object arguments;
    private Object alternate_url;

    public ResponseModel() {
    }

    public ResponseModel(List<Object> items, Integer found, Integer pages, Integer per_page, Integer page, Object clusters, Object arguments, Object alternate_url) {
        this.items = items;
        this.found = found;
        this.pages = pages;
        this.per_page = per_page;
        this.page = page;
        this.clusters = clusters;
        this.arguments = arguments;
        this.alternate_url = alternate_url;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Integer getFound() {
        return found;
    }

    public void setFound(Integer found) {
        this.found = found;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Object getClusters() {
        return clusters;
    }

    public void setClusters(Object clusters) {
        this.clusters = clusters;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    public Object getAlternate_url() {
        return alternate_url;
    }

    public void setAlternate_url(Object alternate_url) {
        this.alternate_url = alternate_url;
    }
}
