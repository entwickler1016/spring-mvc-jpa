package io.spring.temp.domain.partner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "partner",
        indexes = {
                @Index(columnList = "deleted")
        }
)
@SQLDelete(sql = "UPDATE partner SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Partner {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;

    //회사-사업자등록번호
    @Column(length = 256)
    private String corpNumber;

    //회사-이름
    @Column(length = 256)
    private String corpName;

    //회사-주소
    @Column(length = 256)
    private String corpAddress1;

    //회사-상세주소
    @Column(length = 256)
    private String corpAddress2;

    //회사-우편번호
    @Column(length = 256)
    private String corpPost;

    //회사-연락처
    @Column(length = 256)
    private String corpPhone;

    //회사-계좌-은행
    @Column(length = 256)
    private String corpAccountBank;

    //회사-계좌-예금주
    @Column(length = 256)
    private String corpAccountOwner;

    //회사-계좌-번호
    @Column(length = 256)
    private String corpAccountNumber;

    //회사-업무시간
    @Column(length = 256)
    private String corpWorkTime;

    //회사-이메일
    @Column(length = 256)
    private String corpEmail;

    //대표-이름
    @Column(length = 256)
    private String bossName;

    //대표-연락처
    @Column(length = 256)
    private String bossPhone;

    //대표-이메일
    @Column(length = 256)
    private String bossEmail;

    //담당-이름
    @Column(length = 256)
    private String managerName;

    //담당-연락처
    @Column(length = 256)
    private String managerPhone;

    //담당-이메일
    @Column(length = 256)
    private String managerEmail;

}
