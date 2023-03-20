package io.spring.temp.domain.partner.api;

import io.spring.temp.domain.partner.dto.PartnerDTO;
import io.spring.temp.domain.partner.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("partner")
public class PartnerAPI {

    private final PartnerService partnerService;

    @GetMapping("")
    public ResponseEntity<List<PartnerDTO>> getPartners() {
        return ResponseEntity.ok(partnerService.getPartners());
    }

    @PostMapping("")
    public ResponseEntity<PartnerDTO> addPartner(@RequestBody PartnerDTO dto) {
        partnerService.insertPartner(dto);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerDTO> updatePartner(@PathVariable UUID id, @RequestBody PartnerDTO dto) {
        partnerService.updatePartner(id, dto);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PartnerDTO> deletePartner(@PathVariable UUID id) {
        partnerService.deletePartner(id);
        return ResponseEntity.ok(null);
    }
}
