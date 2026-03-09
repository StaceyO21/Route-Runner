package org.launchcode.route_runner.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

import static sun.security.pkcs11.wrapper.Functions.getId;

@Getter
@Setter
@MappedSuperClass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    @Column(name = "id", updatable = false, nullable = false))
    private Long id;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() { return Objects.hashCode(getId());}
}
