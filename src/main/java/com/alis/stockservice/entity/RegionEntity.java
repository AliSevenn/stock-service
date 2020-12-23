package com.alis.stockservice.entity;

import javax.persistence.*;

@Entity
@Table
public class RegionEntity extends BaseEntity {

    private static final long serialVersionUID = 8922184159463686484L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private Long regionId;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RegionType regionType;

    private int postalCode;

    @Column(nullable = false)
    private String name;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
