package com.spring.security.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
// ROLE 간 관계를 정의하는 entity(ex] ROLE_USER < ROLE_MANAGER < ROLE_ADMIN)
@Entity
@Table(name="ROLE_HIERARCHY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleHierarchy implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "child_name")
    private String childName;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_name", referencedColumnName = "child_name")
    private RoleHierarchy parentName;

    @OneToMany(mappedBy = "parentName", cascade={CascadeType.ALL})
    private Set<RoleHierarchy> roleHierarchy = new HashSet<RoleHierarchy>();
}
