package fun.gaol.gaolfun.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_article", schema = "gaolfun", catalog = "")
public class TArticleEntity {
    private String jlid;
    private String artcleTitle;
    private String artcleText;
    private String artcleAuthor;
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
    @Column(name = "artcle_title")
    public String getArtcleTitle() {
        return artcleTitle;
    }

    public void setArtcleTitle(String artcleTitle) {
        this.artcleTitle = artcleTitle;
    }

    @Basic
    @Column(name = "artcle_text")
    public String getArtcleText() {
        return artcleText;
    }

    public void setArtcleText(String artcleText) {
        this.artcleText = artcleText;
    }

    @Basic
    @Column(name = "artcle_author")
    public String getArtcleAuthor() {
        return artcleAuthor;
    }

    public void setArtcleAuthor(String artcleAuthor) {
        this.artcleAuthor = artcleAuthor;
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
        return Objects.equals(jlid, that.jlid) &&
                Objects.equals(artcleTitle, that.artcleTitle) &&
                Objects.equals(artcleText, that.artcleText) &&
                Objects.equals(artcleAuthor, that.artcleAuthor) &&
                Objects.equals(sysTime, that.sysTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jlid, artcleTitle, artcleText, artcleAuthor, sysTime);
    }
}
