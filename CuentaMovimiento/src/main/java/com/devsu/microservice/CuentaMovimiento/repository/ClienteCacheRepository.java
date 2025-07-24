package com.devsu.microservice.CuentaMovimiento.repository;

import com.devsu.microservice.CuentaMovimiento.entity.ClienteCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteCacheRepository extends JpaRepository<ClienteCache,Long> {
}
