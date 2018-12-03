package com.devices.devices.service;

import com.devices.devices.dao.DeviceRepository;
import com.devices.devices.domain.Device;
import com.devices.devices.domain.User;
import com.devices.devices.domain.UserStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public void save(Device device) {
        device.setCreatedAt(new Date());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        device.setOwner(user);
        deviceRepository.save(device);
    }

    public List<Device> findAllDevicesByUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return deviceRepository.findAllByUserId(user);
    }

    public List<Device> getLastCreatedDevices() {
        return deviceRepository.findTop5ByOrderByCreatedAtDesc();
    }

    public List<UserStats> topUsers() {
        List<UserStats> userStats = deviceRepository.topUsers();
        if (userStats.size() > 5) {
            return deviceRepository.topUsers().subList(0, 5);
        } else {
            return deviceRepository.topUsers();
        }
    }
}
