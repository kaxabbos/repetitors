package com.repetitors.repo;

import com.repetitors.model.Ads;
import com.repetitors.model.enums.Category;
import com.repetitors.model.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepo extends JpaRepository<Ads, Long> {

    List<Ads> findAllByNameContainingAndDescription_CategoryAndDescription_Type(String name, Category category, Type type);

    List<Ads> findAllByDescription_Category( Category category);

    List<Ads> findAllByDescription_Type( Type type);
}
