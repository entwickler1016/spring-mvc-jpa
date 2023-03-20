package io.spring.temp.domain.partner.repository;

import io.spring.temp.domain.partner.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {
}
