package com.cat.external.app.update;

import com.alibaba.fastjson.JSON;

public class JSONParser implements ParserAndGenerate {
    @Override
    public Version parser(String response) {
        Version version = JSON.parseObject(response, Version.class);
        return version;
    }

    @Override
    public String generate(RequestVersion requestVersion) {
        return JSON.toJSONString(requestVersion);
    }
}
