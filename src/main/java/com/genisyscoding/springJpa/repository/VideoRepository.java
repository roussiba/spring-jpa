package com.genisyscoding.springJpa.repository;

import com.genisyscoding.springJpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}
