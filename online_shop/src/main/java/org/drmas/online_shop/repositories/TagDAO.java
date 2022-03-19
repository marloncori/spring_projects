package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagDAO extends JpaRepository<Tag, Long> {
    @Query(value = "SELECT t FROM Tag t WHERE t.name = :name")
    List<Tag> findByName(String name);
}
