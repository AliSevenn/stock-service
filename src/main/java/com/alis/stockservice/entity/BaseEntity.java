package com.alis.stockservice.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass

public class BaseEntity implements Serializable {


    private static final long serialVersionUID = -5787267894620680345L;

    @Column
    private LocalDateTime createTime;

    @Column
    private LocalDateTime modifyTime;

    @Column
    private String modifyUser;

    @Column
    private boolean active = true;

    @Version
    @Column
    private Integer version;

    @PreUpdate
    private void setModifyDateTime() {
        setModifyTime(LocalDateTime.now());
    }

    @PrePersist
    private void setCreateDateTime() {
        setCreateTime(LocalDateTime.now());
        setModifyTime(LocalDateTime.now());
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}