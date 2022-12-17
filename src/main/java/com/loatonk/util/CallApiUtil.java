package com.loatonk.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Component
public final class CallApiUtil {
    private static String apikey;

    @Value("${api.key}")
    public void setApikey(String key) {
        apikey = key;
    }

    public static ResponseEntity<String> resultByGetMethod(String uri){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", apikey);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        String url = "https://developer-lostark.game.onstove.com/" + uri;
        URI targetUrl = UriComponentsBuilder
                .fromUriString(url)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();
        return restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, String.class);
    }
}
