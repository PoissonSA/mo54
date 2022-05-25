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
    private String price;

    @Column(name = "type")
    private String type;

    @Column(name = "imgurl")
    private String imgurl;

}
