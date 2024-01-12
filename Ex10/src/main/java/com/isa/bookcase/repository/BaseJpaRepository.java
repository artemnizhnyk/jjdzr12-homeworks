package com.isa.bookcase.repository;

import com.isa.bookcase.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface BaseJpaRepository<T extends AbstractEntity, I> extends JpaRepository<T, I> {
}