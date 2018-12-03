package com.devices.devices.domain;

import javax.persistence.*;
import java.io.Serializable;

public class UserStats implements Serializable{

    private User user;

    private Long deviceCount;

    public UserStats(User user, Long deviceCount) {
        this.deviceCount = deviceCount;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Long deviceCount) {
        this.deviceCount = deviceCount;
    }

}