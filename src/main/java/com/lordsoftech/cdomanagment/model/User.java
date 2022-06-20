package com.lordsoftech.cdomanagment.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Timestamp;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements GenericEntity<User> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
  @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @Column(columnDefinition = "varchar(255) default ''")
  private String email;

  @Column(columnDefinition = "varchar(255) default ''")
  private String password;

  @Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
  private Timestamp createdAt;
  @Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
  private Timestamp updatedAt;

  private Timestamp tokenExpiration;
  private String token;

  private boolean isVerified;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  // public byte[] hashPassword(String password, byte[] salt) throws
  // InvalidKeySpecException, NoSuchAlgorithmException {
  // SecretKeyFactory factory = null;
  // factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
  // KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
  // return factory.generateSecret(spec).getEncoded();
  // }

  // public byte[] generateHashSalt() {
  // SecureRandom random = new SecureRandom();
  // byte[] salt = new byte[16];
  // random.nextBytes(salt);
  // return salt;
  // }

  public User() {

  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void update(User source) {
    this.setEmail(source.getEmail());
    this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

  }

  @Override
  public User createNewInstance() {
    User newInstance = new User();
    newInstance.update(this);
    return (newInstance);
  };

}
