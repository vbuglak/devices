package com.devices.devices.dao;

import com.devices.devices.domain.Device;
import com.devices.devices.domain.User;
import com.devices.devices.domain.UserStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {

    @Query("select a from Device a where a.owner=?1")
    public List<Device> findAllByUserId(User user);

    public List<Device> findTop5ByOrderByCreatedAtDesc();

    @Query("SELECT NEW com.devices.devices.domain.UserStats ( a.owner, COUNT(a.owner)) " +
            "FROM Device a " +
            "GROUP BY a.owner " +
            "ORDER BY COUNT(a.owner) DESC")
    public List<UserStats> topUsers();

}