package com.mk.photoz.cloning.repository;

import com.mk.photoz.cloning.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotozRepository extends CrudRepository<Photo, Integer> {

}
