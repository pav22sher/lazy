package com.example.lazy.dao;

import com.example.lazy.model.Man;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManRepository extends JpaRepository<Man, Long> {
    @Query("select m from man m where m.id = :id")
    Man getEntityById1(Long id);

    @Query("select m from man m left join fetch m.address where m.id = :id")
    Man getEntityById2(Long id);

    @EntityGraph(value = "man-entity-graph")
    @Query("select m from man m where m.id = :id")
    Man getEntityById3(Long id);
}
