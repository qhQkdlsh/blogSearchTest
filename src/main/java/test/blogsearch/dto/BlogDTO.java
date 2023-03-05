package test.blogsearch.dto;

import java.util.List;

public class BlogDTO {
    private MetaDTO meta;
    private List<DocumentsDTO> documents;

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public List<DocumentsDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentsDTO> documents) {
        this.documents = documents;
    }

    public BlogDTO() {
        this.meta = new MetaDTO();
    }
}

class MetaDTO{
    private Integer total_count;
    private Integer pageable_count;
    private Boolean is_end;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Integer getPageable_count() {
        return pageable_count;
    }

    public void setPageable_count(Integer pageable_count) {
        this.pageable_count = pageable_count;
    }

    public Boolean getIs_end() {
        return is_end;
    }

    public void setIs_end(Boolean is_end) {
        this.is_end = is_end;
    }

    public MetaDTO() {
        this.total_count = 0;
    }

    @Override
    public String toString() {
        return "MetaDTO{" +
                "total_count=" + total_count +
                ", pageable_count=" + pageable_count +
                ", is_end=" + is_end +
                '}';
    }
}

class DocumentsDTO{
    private String title;
    private String contents;
    private String url;
    private String blogname;
    private String thumbnail;
    private String datetime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        if(datetime.indexOf('T') > -1){
            datetime = datetime.substring(0,10)+" "+datetime.substring(11,19);
        }else if(datetime.length() == 8){
            datetime = datetime.substring(0,4)+"-"+datetime.substring(4,6)+"-"+datetime.substring(6,8);
        }
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "DocumentsDTO{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", url='" + url + '\'' +
                ", blogname='" + blogname + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}