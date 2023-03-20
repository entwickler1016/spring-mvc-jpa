package io.spring.temp.domain.partner.api;

import io.spring.temp.domain.partner.dto.PartnerDTO;
import io.spring.temp.domain.partner.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("partner")
public class PartnerAPI {

    private final PartnerService partnerService;

    @GetMapping("")
    public ResponseEntity<List<PartnerDTO>> getPartners() {
        return ResponseEntity.ok(partnerService.getPartners());
    }

    @PostMapping("add")
    public ResponseEntity<PartnerDTO> addPartner(PartnerDTO dto) {
        partnerService.addPartner(dto);
        return ResponseEntity.ok(null);
    }
}
