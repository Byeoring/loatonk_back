package com.loatonk.character.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @GetMapping("")
    public String callApi() throws IOException {
        StringBuilder result = new StringBuilder();

        String urlStr = "https://developer-lostark.game.onstove.com/characters/%EB%8C%88%EB%8B%A4/siblings";
        URL url = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Authorization", "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAwMDEwOTgifQ.H8D_EEyXNZLJO9nQEc6iP1Ewinj7xe8VdeF-YcCo404BIarmuJG1BJu3MAnJtV4ayuqPk3JztbI8bHyIEb2RVEq7He-mP7Vet8onAT1Z7NrSuN990fn_uSFKTfHqlp134Ff89_FuQDjG-mlN4f3qiaRBVhHgya0gBXMz-WNlqQ6NylkxAqYCDEUYooYmX-G046mp0bZeaO_lpBeaWsrAjpi2ozIrk7IhuiTPqiTX4-akgsUAt0JPkiH85HiUrn6Jd-bICJeTtR3vF3b94xkUPP5Ic9jqQ3o1a9xPbgGZSqtU4D0-uuLDbv0BE6xWgB-rZMbkzIfAcDcqdKK0AQ4-lA");

        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

        String returnLine;

        while((returnLine = br.readLine()) != null){
            result.append(returnLine).append("\n\r");
        }

        urlConnection.disconnect();

        return result.toString();
    }

    @GetMapping("/test")
    public String callInfo(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAwMDEwOTgifQ.H8D_EEyXNZLJO9nQEc6iP1Ewinj7xe8VdeF-YcCo404BIarmuJG1BJu3MAnJtV4ayuqPk3JztbI8bHyIEb2RVEq7He-mP7Vet8onAT1Z7NrSuN990fn_uSFKTfHqlp134Ff89_FuQDjG-mlN4f3qiaRBVhHgya0gBXMz-WNlqQ6NylkxAqYCDEUYooYmX-G046mp0bZeaO_lpBeaWsrAjpi2ozIrk7IhuiTPqiTX4-akgsUAt0JPkiH85HiUrn6Jd-bICJeTtR3vF3b94xkUPP5Ic9jqQ3o1a9xPbgGZSqtU4D0-uuLDbv0BE6xWgB-rZMbkzIfAcDcqdKK0AQ4-lA");
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        URI targetUrl = UriComponentsBuilder
                .fromUriString("https://developer-lostark.game.onstove.com/characters/댈다/siblings")
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();
        ResponseEntity<String> result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, String.class);
        System.out.println(result);
        return result.getBody();
    }
}
