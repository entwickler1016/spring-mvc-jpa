package io.spring.temp.domain.partner.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.spring.temp.domain.partner.entity.Partner;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerDTO {
    private UUID id;
    private boolean deleted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modified;
    private String corpNumber;
    private String corpName;
    private String corpAddress1;
    private String corpAddress2;
    private String corpPost;
    private String corpPhone;
    private String corpAccountBank;
    private String corpAccountOwner;
    private String corpAccountNumber;
    private String corpWorkTime;
    private String corpEmail;
    private String bossName;
    private String bossPhone;
    private String bossEmail;
    private String managerName;
    private String managerPhone;
    private String managerEmail;

    public static PartnerDTO toDTO(Partner entity) {
        PartnerDTO dto = new PartnerDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public Partner toEntity() {
        Partner entity = new Partner();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
