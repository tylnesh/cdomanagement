package com.lordsoftech.cdomanagment.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements GenericEntity<AppUser> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @Column(columnDefinition = "varchar(255) default ''")
  private String username;

  @Column(columnDefinition = "varchar(255) default ''")
  private String email;

  @Column(columnDefinition = "varchar(255) default ''")
  private String password;

  @CreationTimestamp
  @Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
  private Timestamp updatedAt;

  private boolean isVerified;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "role_id", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="role_id")}  )
  private Collection<Role> roles = new ArrayList<>();


  public AppUser(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public AppUser(String usernameOrEmail, String password) {
    this.username = usernameOrEmail;
    this.email = usernameOrEmail;
    this.password = password;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void update(AppUser source) {
    this.setEmail(source.getEmail());
    this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

  }

  @Override
  public AppUser createNewInstance() {
    AppUser newInstance = new AppUser();
    newInstance.update(this);
    return (newInstance);
  };

}
