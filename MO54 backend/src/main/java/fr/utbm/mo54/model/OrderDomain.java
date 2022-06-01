package fr.utbm.mo54.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "number")
    private Integer number;

    @Column(name = "brand")
    private String brand;

    @Column(name = "time")
    private String time;

    @Column(name = "user")
    private String user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pid",insertable=false,updatable=false)
    private PieceDomain pieceDomain;
}
