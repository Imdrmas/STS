package com.dvd.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dvd.ecommerce.model.ReplayComment;

@Repository
public interface ReplayCommentRepository extends JpaRepository<ReplayComment, Long> {


}
