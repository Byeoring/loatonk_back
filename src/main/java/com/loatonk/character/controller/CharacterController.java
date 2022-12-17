package com.loatonk.character.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loatonk.character.model.CharacterInfo;
import com.loatonk.character.model.service.CharacterService;
import com.loatonk.util.CallApiUtil;
import com.loatonk.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterService service;

    @Autowired
    public CharacterController(CharacterService service) {
        this.service = service;
    }


    @GetMapping("/{charName}/siblings")
    public ResponseEntity<?> findCharacterList(@PathVariable String charName) throws Exception {
        String uri = "characters/"+ charName +"/siblings";
        ResponseEntity<String> result = CallApiUtil.resultByGetMethod(uri);
        if(result.getStatusCode() != HttpStatus.OK){
            return new ResponseEntity<>(result.getStatusCode());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<CharacterInfo> characterInfos = objectMapper.readValue(result.getBody(), new TypeReference<List<CharacterInfo>>(){});
        service.charactersSort(characterInfos);
        return ResponseUtil.responseCollection(characterInfos);
    }
}
