package fr.utbm.mo54.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "piece")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PieceDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "type")
    private Integer type;

    @Column(name = "rate")
    private String rate;

    @Column(name = "ctimes")
    private Integer ctimes;

    @Column(name = "imgurl")
    private String imgurl;

}
