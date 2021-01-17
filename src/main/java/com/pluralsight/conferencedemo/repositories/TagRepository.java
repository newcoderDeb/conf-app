package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
