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
@Table(name = "SanPham")
public class SanPham implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;
    @Column(name = "Ma")
    private String ma;
    @ToString.Include
    @Column(name = "Ten")
    private String ten;

}
