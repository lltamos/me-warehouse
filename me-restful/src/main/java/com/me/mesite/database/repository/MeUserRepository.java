package com.me.mesite.database.repository;

import com.me.mesite.database.entity.MeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeUserRepository extends JpaRepository<MeUser, Long> {
}
