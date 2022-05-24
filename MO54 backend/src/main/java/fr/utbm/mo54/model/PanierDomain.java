package fr.utbm.mo54.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "panier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "number")
    private Integer number;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pid",insertable=false,updatable=false)
    private PieceDomain pieceDomain;
}
