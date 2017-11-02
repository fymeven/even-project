package com.even.service.impl.dubbo;

import com.even.service.dubbo.DemoService;

/**
 * Created by even on 2017/11/2.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String getName(String name) {
        return new StringBuilder("hell,").append(name).toString();
    }
}
