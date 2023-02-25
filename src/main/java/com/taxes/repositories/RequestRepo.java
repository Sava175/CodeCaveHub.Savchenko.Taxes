package com.taxes.repositories;

import com.taxes.domain.Report;
import com.taxes.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Long> {
    List<Request> findAllByStatus(Request.State state);
    List<Request> findAllByDescriptionContaining(String words);

}
