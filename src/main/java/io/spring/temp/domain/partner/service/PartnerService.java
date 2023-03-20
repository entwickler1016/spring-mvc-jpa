package io.spring.temp.domain.partner.service;

import io.spring.temp.domain.partner.dto.PartnerDTO;
import io.spring.temp.domain.partner.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public List<PartnerDTO> getPartners(){
        return partnerRepository.findAll().stream().map(PartnerDTO::toDTO).toList();
    }

    public Optional<PartnerDTO> getPartnerById(UUID id){
        return partnerRepository.findById(id).map(PartnerDTO::toDTO);
    }

    @Transactional
    public void insertPartner(PartnerDTO dto){
        partnerRepository.save(dto.toEntity());
    }

    @Transactional
    public void updatePartner(UUID id, PartnerDTO dto){
        dto.setId(id);
        partnerRepository.save(dto.toEntity());
    }

    @Transactional
    public void deletePartner(UUID id){
        partnerRepository.deleteById(id);
    }

}
