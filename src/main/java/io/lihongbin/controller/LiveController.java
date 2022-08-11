package io.lihongbin.controller;

import io.lihongbin.controller.service.LiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("live")
public class LiveController {

    private final LiveService liveService;

    public LiveController(LiveService liveService) {
        this.liveService = liveService;
    }

    @RequestMapping("publish")
    public void publish(HttpServletRequest request, HttpServletResponse response, String name) {
        log.info("publish method: {}, name: {}", request.getMethod(), name);
        if (!liveService.publish(name)) {
            response.setStatus(404);
        }
    }

}
