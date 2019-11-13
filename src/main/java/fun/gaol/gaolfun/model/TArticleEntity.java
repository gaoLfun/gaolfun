package fun.gaol.gaolfun.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_article", schema = "gaolfun", catalog = "")
public class TArticleEntity {
    private String jlid;
    private String articleTitle;
    private String articleText;
    private String articleAuthor;
    private Timestamp sysTime;

    @Id
    @Column(name = "jlid")
    public String getJlid() {
        return jlid;
    }

    public void setJlid(String jlid) {
        this.jlid = jlid;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_text")
    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    @Basic
    @Column(name = "article_author")
    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    @Basic
    @Column(name = "sys_time")
    public Timestamp getSysTime() {
        return sysTime;
    }

    public void setSysTime(Timestamp sysTime) {
        this.sysTime = sysTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TArticleEntity that = (TArticleEntity) o;

        if (jlid != null ? !jlid.equals(that.jlid) : that.jlid != null) return false;
        if (articleTitle != null ? !articleTitle.equals(that.articleTitle) : that.articleTitle != null) return false;
        if (articleText != null ? !articleText.equals(that.articleText) : that.articleText != null) return false;
        if (articleAuthor != null ? !articleAuthor.equals(that.articleAuthor) : that.articleAuthor != null)
            return false;
        if (sysTime != null ? !sysTime.equals(that.sysTime) : that.sysTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jlid != null ? jlid.hashCode() : 0;
        result = 31 * result + (articleTitle != null ? articleTitle.hashCode() : 0);
        result = 31 * result + (articleText != null ? articleText.hashCode() : 0);
        result = 31 * result + (articleAuthor != null ? articleAuthor.hashCode() : 0);
        result = 31 * result + (sysTime != null ? sysTime.hashCode() : 0);
        return result;
    }
}
