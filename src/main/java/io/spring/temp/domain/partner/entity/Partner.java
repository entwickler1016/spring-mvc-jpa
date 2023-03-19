package io.spring.temp.domain.partner.entity;

import io.spring.temp.global.common.BaseTime;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(indexes = {
    @Index(columnList = "deleted")
})
@SQLDelete(sql = "UPDATE partner SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Partner extends BaseTime {

    //회사-사업자등록번호
    @Column(nullable=false, length = 16)
    private String corpNumber;

    //회사-이름
    @Column(nullable=false, length = 64)
    private String corpName;

    //회사-주소
    @Column(nullable=false, length = 128)
    private String corpAddress1;

    //회사-상세주소
    @Column(nullable=true, length = 128)
    private String corpAddress2;

    //회사-우편번호
    @Column(nullable=false, length = 32)
    private String corpPost;

    //회사-연락처
    @Column(nullable=false, length = 32)
    private String corpPhone;

    //회사-계좌-은행
    @Column(nullable=true, length = 32)
    private String corpAccountBank;

    //회사-계좌-예금주
    @Column(nullable=true, length = 32)
    private String corpAccountOwner;

    //회사-계좌-번호
    @Column(nullable=true, length = 32)
    private String corpAccountNumber;

    //회사-업무시간
    @Column(nullable=true, length = 64)
    private String corpWorkTime;

    //회사-이메일
    @Column(nullable=true, length = 128)
    private String corpEmail;

    //대표-이름
    @Column(nullable=false, length = 16)
    private String bossName;

    //대표-연락처
    @Column(nullable=false, length = 32)
    private String bossPhone;

    //대표-이메일
    @Column(nullable=true, length = 128)
    private String bossEmail;

    //담당-이름
    @Column(nullable=false, length = 16)
    private String managerName;

    //담당-연락처
    @Column(nullable=false, length = 32)
    private String managerPhone;

    //담당-이메일
    @Column(nullable=true, length = 128)
    private String managerEmail;

}
