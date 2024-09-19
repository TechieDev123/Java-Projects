package com.bank.app.rest;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountInfo {
    private String accountHolderName;
    private String accountType;
    private String accountStatus;
    private String bankName;
    private String phoneNumber;
    private String panCard;
    private Float balance;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getBankName() {
        return bankName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPanCard() {
        return panCard;
    }

    public Float getBalance() {
        return balance;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", bankName='" + bankName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", panCard='" + panCard + '\'' +
                ", balance=" + balance +
                '}';
    }
}
