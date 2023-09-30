package com.mwaqee.spring.auth.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "spring_mwaqee_roles")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name="role_id",unique=true)
    private String roleId;
    
    private String name;

    /*@OneToMany(targetEntity=User.class, mappedBy="userRole", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/
}
