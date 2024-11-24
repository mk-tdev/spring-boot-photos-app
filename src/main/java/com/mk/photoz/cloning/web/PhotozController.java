package com.mk.photoz.cloning.web;

import com.mk.photoz.cloning.service.PhotozService;
import com.mk.photoz.cloning.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {
    private final PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }
//    private List<Photo> dbList = List.of(new Photo("1", "hello.jpeg"), new Photo("2", "there.jpeg"));

    @GetMapping("/hello")
    public String hello() {
        return "Hello, there!";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get () {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get (@PathVariable Integer id) {
        Photo photo = photozService.get(id);

        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete (@PathVariable Integer id) {
        photozService.remove(id);
    }

//    @PostMapping("/photoz")
//    public Photo create(@RequestBody @Valid Photo photo) {
//        photo.setId(UUID.randomUUID().toString());
//        photozService.save(photo.getId(), photo);
//        return photo;
//    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("file") MultipartFile file) throws IOException {
        Photo photo = photozService.save(file.getOriginalFilename(), file.getBytes(), file.getContentType());
        return photo;
    }
}
