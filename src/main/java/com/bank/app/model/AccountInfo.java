package com.bank.app.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@XmlRootElement
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private String accountStatus;
    private String branch;
    private String phoneNumber;
    private String panCard;
    private Float balance;
}
