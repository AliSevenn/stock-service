package com.alis.stockservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class CategoryEntity extends BaseEntity {

    private static final long serialVersionUID = 2134433991979263341L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_category_id", referencedColumnName = "category_id")
    private CategoryEntity mainCategory;

    @OneToMany(mappedBy = "mainCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CategoryEntity> categories = new HashSet<>();

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(CategoryEntity mainCategory) {
        this.mainCategory = mainCategory;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }
}
