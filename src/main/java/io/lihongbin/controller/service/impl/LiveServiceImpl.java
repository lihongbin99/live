package io.lihongbin.controller.service.impl;

import io.lihongbin.config.LiveConfig;
import io.lihongbin.controller.service.LiveService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;

@Service
public class LiveServiceImpl implements LiveService {

    private final LiveConfig liveConfig;

    public LiveServiceImpl(LiveConfig liveConfig) {
        this.liveConfig = liveConfig;
    }

    @Override
    public boolean publish(String name) {
        return StringUtils.hasLength(name) &&
                (new File(liveConfig.getAuthPath() + File.separator + name)).exists();
    }

}
