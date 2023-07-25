package com.FullStackWebApplication.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.FullStackWebApplication.Backend.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	@Modifying
	@Query(value = "INSERT INTO student_table(id, contact, email, name, year) VALUES (:id, :contact, :email,:name,:year)", nativeQuery = true)
	@Transactional
	int addRecord(@Param("id") String id, @Param("contact") String contact, @Param("email") String email,
			@Param("name") String name, @Param("year") String year);

	@Query(value = "select count(*) from student_table st where st.id=:id", nativeQuery = true)
	int findRecordById(@Param("id") String id);
}
