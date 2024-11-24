package com.mk.photoz.cloning.service;

import com.mk.photoz.cloning.model.Photo;
import com.mk.photoz.cloning.repository.PhotozRepository;
import org.springframework.stereotype.Service;

import java.util.*;

//@Component
@Service
public class PhotozService {
    private final PhotozRepository photozRepository;

//    private Map<String, Photo> db = new HashMap<>(){{
//        put("1", new Photo(1, "hello.jpeg"));
//        put("2", new Photo(2, "world.jpeg"));
//    }};

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, byte[] data, String contentType) {
        Photo photo = new Photo();
//        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setPhotoData(data);
        photo.setContentType(contentType);

        photozRepository.save(photo);
//        db.put(photo.getId(), photo);
        return photo;
    }
}
