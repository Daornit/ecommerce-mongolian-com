package mongolian.ecommerce.com.Entities;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class PostNew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String article;

    private String detail;

    private Date publishedDate;

    private String category;

    private String imgUrl;

    public PostNew() {
    }

    public PostNew(String article, String detail, Date publishedDate, String category, String imgUrl) {
        this.article = article;
        this.detail = detail;
        this.publishedDate = publishedDate;
        this.category = category;
        this.imgUrl = imgUrl;
    }
    @PrePersist
    @PreUpdate
    public void setDate(){
        this.setPublishedDate(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPublishedDate() {
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = formatter.format(this.publishedDate);
        return strDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "PostNew{" +
                "id=" + id +
                ", article='" + article + '\'' +
                ", detail='" + detail + '\'' +
                ", publishedDate=" + publishedDate +
                ", category='" + category + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
