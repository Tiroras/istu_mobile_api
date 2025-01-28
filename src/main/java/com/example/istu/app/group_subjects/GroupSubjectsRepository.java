package com.example.istu.app.group_subjects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSubjectsRepository extends JpaRepository<GroupSubjects, Long> {
}
