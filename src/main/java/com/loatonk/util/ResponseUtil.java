package com.loatonk.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Map;

public final class ResponseUtil {

    public static ResponseEntity<?> responseCollection(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    public static ResponseEntity<?> responseMap(Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> responseObject(T obj) {
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
