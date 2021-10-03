package com.example.springboot.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Commute> commutes = new HashSet<>();

    public static Predicate<User> createFilter(String filter) {
        return new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return filter(filter, user);
            }
        };
    }

    public static boolean filter(String filter, User user) {
        if(filter == null) {
            return true;
        }
        if(user.getName().toLowerCase(Locale.ROOT).contains(filter.toLowerCase(Locale.ROOT))) {
            return true;
        } else {
            return false;
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Commute> getCommutes() {
        return commutes;
    }
}
