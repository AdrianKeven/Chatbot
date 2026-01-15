package com.adriank.Chatbot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bot extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private User owner;
}
