package io.spring.temp.domain.partner.repository;

import io.spring.temp.domain.partner.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, String> {
}
