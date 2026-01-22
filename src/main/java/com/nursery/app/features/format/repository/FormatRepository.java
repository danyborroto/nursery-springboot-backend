package com.nursery.app.features.format.repository;

import com.nursery.app.features.format.entity.Format;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatRepository extends JpaRepository<Format, Integer> {
}
