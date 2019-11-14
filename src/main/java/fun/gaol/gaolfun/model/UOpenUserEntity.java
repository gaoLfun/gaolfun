package fun.gaol.gaolfun.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "u_OpenUser", schema = "gaolfun", catalog = "")
public class UOpenUserEntity {
    private String jlid;
    private String openType;
    private String openId;
    private String gender;
    private String nickname;
    private String avatar;
    private Timestamp sysTime;

    @Basic
    @Column(name = "jlid")
    public String getJlid() {
        return jlid;
    }

    public void setJlid(String jlid) {
        this.jlid = jlid;
    }

    @Basic
    @Column(name = "openType")
    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    @Basic
    @Column(name = "openId")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

        UOpenUserEntity that = (UOpenUserEntity) o;

        if (jlid != null ? !jlid.equals(that.jlid) : that.jlid != null) return false;
        if (openType != null ? !openType.equals(that.openType) : that.openType != null) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
        if (sysTime != null ? !sysTime.equals(that.sysTime) : that.sysTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jlid != null ? jlid.hashCode() : 0;
        result = 31 * result + (openType != null ? openType.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (sysTime != null ? sysTime.hashCode() : 0);
        return result;
    }
}
