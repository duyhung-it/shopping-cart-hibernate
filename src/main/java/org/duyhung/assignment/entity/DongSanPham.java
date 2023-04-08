package org.duyhung.assignment.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true,includeFieldNames = false)
@Entity
@Table(name="DongSP")
public class DongSanPham implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    @Column(name = "Ma",unique = true)
    private String ma;
    @ToString.Include
    @Column(name = "Ten")
    private String ten;
}
