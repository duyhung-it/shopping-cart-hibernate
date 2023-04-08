package org.duyhung.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true,includeFieldNames = false)
@Entity
@AllArgsConstructor
@Table(name = "ChucVu")
public class ChucVu implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    @Column(name = "Ma", unique = true)
    private String ma;
    @ToString.Include
    @Column(name = "Ten")
    private String ten;

    public ChucVu(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}
