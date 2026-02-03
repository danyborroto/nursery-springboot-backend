package com.nursery.app.features.information.repository;

import com.nursery.app.features.information.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Integer> {
}
