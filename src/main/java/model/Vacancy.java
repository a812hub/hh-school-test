package model;

import java.util.List;

public class Vacancy {
    private String id;
    private Boolean premium;
    private String name;
    private Object department;
    private Boolean has_test;
    private Boolean response_letter_required;
    private Object area;
    private Object salary;
    private Object type;
    private Object address;
    private String response_url;
    private String sort_point_distance;
    private Object employer;
    private String published_at;
    private String created_at;
    private Boolean archived;
    private String apply_alternate_url;
    private Object insider_interview;
    private String url;
    private String alternate_url;
    private List<Object> relations;
    private Object snippet;
    private Object contacts;
    private Object schedule;
    private Object working_days;
    private Object working_time_intervals;
    private Object working_time_modes;
    private Boolean accept_temporary;

    public Vacancy() {
    }

    public Vacancy(String id, Boolean premium, String name, Object department, Boolean has_test, Boolean response_letter_required, Object area, Object salary, Object type, Object address, String response_url, String sort_point_distance, Object employer, String published_at, String created_at, Boolean archived, String apply_alternate_url, Object insider_interview, String url, String alternate_url, List<Object> relations, Object snippet, Object contacts, Object schedule, Object working_days, Object working_time_intervals, Object working_time_modes, Boolean accept_temporary) {
        this.id = id;
        this.premium = premium;
        this.name = name;
        this.department = department;
        this.has_test = has_test;
        this.response_letter_required = response_letter_required;
        this.area = area;
        this.salary = salary;
        this.type = type;
        this.address = address;
        this.response_url = response_url;
        this.sort_point_distance = sort_point_distance;
        this.employer = employer;
        this.published_at = published_at;
        this.created_at = created_at;
        this.archived = archived;
        this.apply_alternate_url = apply_alternate_url;
        this.insider_interview = insider_interview;
        this.url = url;
        this.alternate_url = alternate_url;
        this.relations = relations;
        this.snippet = snippet;
        this.contacts = contacts;
        this.schedule = schedule;
        this.working_days = working_days;
        this.working_time_intervals = working_time_intervals;
        this.working_time_modes = working_time_modes;
        this.accept_temporary = accept_temporary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public Boolean getHas_test() {
        return has_test;
    }

    public void setHas_test(Boolean has_test) {
        this.has_test = has_test;
    }

    public Boolean getResponse_letter_required() {
        return response_letter_required;
    }

    public void setResponse_letter_required(Boolean response_letter_required) {
        this.response_letter_required = response_letter_required;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public Object getSalary() {
        return salary;
    }

    public void setSalary(Object salary) {
        this.salary = salary;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getResponse_url() {
        return response_url;
    }

    public void setResponse_url(String response_url) {
        this.response_url = response_url;
    }

    public String getSort_point_distance() {
        return sort_point_distance;
    }

    public void setSort_point_distance(String sort_point_distance) {
        this.sort_point_distance = sort_point_distance;
    }

    public Object getEmployer() {
        return employer;
    }

    public void setEmployer(Object employer) {
        this.employer = employer;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getApply_alternate_url() {
        return apply_alternate_url;
    }

    public void setApply_alternate_url(String apply_alternate_url) {
        this.apply_alternate_url = apply_alternate_url;
    }

    public Object getInsider_interview() {
        return insider_interview;
    }

    public void setInsider_interview(Object insider_interview) {
        this.insider_interview = insider_interview;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlternate_url() {
        return alternate_url;
    }

    public void setAlternate_url(String alternate_url) {
        this.alternate_url = alternate_url;
    }

    public List<Object> getRelations() {
        return relations;
    }

    public void setRelations(List<Object> relations) {
        this.relations = relations;
    }

    public Object getSnippet() {
        return snippet;
    }

    public void setSnippet(Object snippet) {
        this.snippet = snippet;
    }

    public Object getContacts() {
        return contacts;
    }

    public void setContacts(Object contacts) {
        this.contacts = contacts;
    }

    public Object getSchedule() {
        return schedule;
    }

    public void setSchedule(Object schedule) {
        this.schedule = schedule;
    }

    public Object getWorking_days() {
        return working_days;
    }

    public void setWorking_days(Object working_days) {
        this.working_days = working_days;
    }

    public Object getWorking_time_intervals() {
        return working_time_intervals;
    }

    public void setWorking_time_intervals(Object working_time_intervals) {
        this.working_time_intervals = working_time_intervals;
    }

    public Object getWorking_time_modes() {
        return working_time_modes;
    }

    public void setWorking_time_modes(Object working_time_modes) {
        this.working_time_modes = working_time_modes;
    }

    public Boolean getAccept_temporary() {
        return accept_temporary;
    }

    public void setAccept_temporary(Boolean accept_temporary) {
        this.accept_temporary = accept_temporary;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id='" + id + '\'' +
                ", premium=" + premium +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", has_test=" + has_test +
                ", response_letter_required=" + response_letter_required +
                ", area=" + area +
                ", salary=" + salary +
                ", type=" + type +
                ", address=" + address +
                ", response_url='" + response_url + '\'' +
                ", sort_point_distance='" + sort_point_distance + '\'' +
                ", employer=" + employer +
                ", published_at='" + published_at + '\'' +
                ", created_at='" + created_at + '\'' +
                ", archived=" + archived +
                ", apply_alternate_url='" + apply_alternate_url + '\'' +
                ", insider_interview=" + insider_interview +
                ", url='" + url + '\'' +
                ", alternate_url='" + alternate_url + '\'' +
                ", relations=" + relations +
                ", snippet=" + snippet +
                ", contacts=" + contacts +
                ", schedule=" + schedule +
                ", working_days=" + working_days +
                ", working_time_intervals=" + working_time_intervals +
                ", working_time_modes=" + working_time_modes +
                ", accept_temporary=" + accept_temporary +
                '}';
    }
}
