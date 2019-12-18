package com.camunda.bpm.servicesdemo.util;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ApplicationHelper {

    public static URI buildURI(String url, String path){
        return UriComponentsBuilder.fromHttpUrl(url+path).build().encode().toUri();
    }
}
