package com.devices.devices.controller;

import com.devices.devices.config.RabbitConfig;
import org.apache.log4j.Logger;
import com.devices.devices.domain.Device;
import com.devices.devices.service.DeviceService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registry")
public class DeviceController {

    Logger logger = Logger.getLogger(DeviceController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    public String userDevice(Model model) {
        model.addAttribute("devices", deviceService.findAllDevicesByUser());
        return "userDevice";
    }

    @RequestMapping(value = "/json/devices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Device> userDeviceJson() {
        return deviceService.findAllDevicesByUser();
    }

    @RequestMapping(value = "/xml/devices", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<Device> userDeviceXml() {
        return deviceService.findAllDevicesByUser();
    }

    @GetMapping("/devices/add")
    public String addDevicePage(Model model) {
        model.addAttribute("Device", new Device());
        return "deviceReg";
    }

    @PostMapping("/devices/add")
    public String addDevice(@ModelAttribute("Device") Device device) {
        deviceService.save(device);
        logger.info("Emit to queue-order");
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, "device created");
        return "redirect:/registry/devices";
    }

    @GetMapping("/devices/stats")
    public String stats(Model model) {
        model.addAttribute("devices", deviceService.getLastCreatedDevices());
        model.addAttribute("topUsers", deviceService.topUsers());
        return "statsDevice";
    }
}
