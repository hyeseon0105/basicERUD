package com.my.basicCRUD.emtty;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class Member {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(name = "member_name",length = 100, nullable = false)
    private String name;
    private int age;
    private String address;
}
