package com.lordsoftech.cdomanagment.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Timestamp;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
  @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @Column(columnDefinition = "varchar(255) default ''")
  private String email;

  @Column(columnDefinition = "blob(255) default ''")
  private byte[] passwordHashed;

  @Column(columnDefinition = "blob(16) default ''")
  private byte[] salt;

  private Timestamp createdAt;
  private Timestamp updatedAt;

  private Timestamp tokenExpiration;
  private String token;

  private boolean isVerified;

  byte[] hashPassword(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
    SecretKeyFactory factory = null;
    factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
    return factory.generateSecret(spec).getEncoded();
  }

  byte[] generateHashSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return salt;
  }

<<<<<<< HEAD
  private boolean isVerified;
=======
  public User() {
  }
>>>>>>> 613793c81fdeb07e51150809a482a5e3b9a82d2e

}
