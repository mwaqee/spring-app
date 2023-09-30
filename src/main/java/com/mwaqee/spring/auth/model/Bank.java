package com.mwaqee.spring.auth.model;

import javax.persistence.*;

@Entity
@Table(name = "spring_mwaqee_banks")
public class Bank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name="bank_id", unique=true)
    private String bankId;
    private String bankAccountNo;
    private String bankAccountTitle;
    private String bankAccountType;
    private String bankName;
    private String bankRoutingNo;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountTitle() {
        return bankAccountTitle;
    }

    public void setBankAccountTitle(String bankAccountTitle) {
        this.bankAccountTitle = bankAccountTitle;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankRoutingNo() {
        return bankRoutingNo;
    }

    public void setBankRoutingNo(String bankRoutingNo) {
        this.bankRoutingNo = bankRoutingNo;
    }
}
