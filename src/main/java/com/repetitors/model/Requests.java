package com.repetitors.model;

import com.repetitors.model.enums.RequestStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Requests {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ads ad;
    @OneToOne(fetch = FetchType.LAZY)
    private Users user;
    @Column(length = 5000)
    private String message;
    private String tel;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    public Requests(Ads ad, Users user, String message, String tel) {
        this.ad = ad;
        this.user = user;
        this.message = message;
        this.tel = tel;
        status = RequestStatus.FRESH;
    }
}
