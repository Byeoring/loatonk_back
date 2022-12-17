package com.loatonk.character.model.service;

import com.loatonk.character.model.CharacterInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Override
    public void charactersSort(List<CharacterInfo> characterInfos) {
        characterInfos.sort((o1, o2) -> o2.getServerName().equals(o1.getServerName())
                ? o2.getItemAvgLevel().compareTo(o1.getItemAvgLevel())
                : o2.getServerName().compareTo(o1.getServerName()));
    }
}
