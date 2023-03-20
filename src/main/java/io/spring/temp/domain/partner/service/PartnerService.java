package io.spring.temp.domain.partner.service;

import io.spring.temp.domain.partner.dto.PartnerDTO;
import io.spring.temp.domain.partner.entity.Partner;
import io.spring.temp.domain.partner.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public List<PartnerDTO> getPartners(){
        return partnerRepository.findAll().stream().map(PartnerDTO::toDTO).toList();
    }

    public Optional<PartnerDTO> getPartnerById(String id){
        return partnerRepository.findById(id).map(PartnerDTO::toDTO);
    }

    public void addPartner(PartnerDTO dto){
        partnerRepository.save(dto.toEntity());
    }

    public void updatePartner(PartnerDTO dto){
        partnerRepository.save(dto.toEntity());
    }

    public void deletePartner(String id){
        partnerRepository.deleteById(id);
    }

}
