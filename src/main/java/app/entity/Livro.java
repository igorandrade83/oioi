package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela LIVRO
 * @generated
 */
@Entity
@Table(name = "\"LIVRO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Livro")
public class Livro implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "Nome", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @Column(name = "Autor", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String autor;

  /**
  * @generated
  */
  @Column(name = "ISBN", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String isBN;

  /**
   * Construtor
   * @generated
   */
  public Livro(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Livro setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome
   * return nome
   * @generated
   */
  
  public java.lang.String getNome(){
    return this.nome;
  }

  /**
   * Define nome
   * @param nome nome
   * @generated
   */
  public Livro setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém autor
   * return autor
   * @generated
   */
  
  public java.lang.String getAutor(){
    return this.autor;
  }

  /**
   * Define autor
   * @param autor autor
   * @generated
   */
  public Livro setAutor(java.lang.String autor){
    this.autor = autor;
    return this;
  }

  /**
   * Obtém isBN
   * return isBN
   * @generated
   */
  
  public java.lang.String getIsBN(){
    return this.isBN;
  }

  /**
   * Define isBN
   * @param isBN isBN
   * @generated
   */
  public Livro setIsBN(java.lang.String isBN){
    this.isBN = isBN;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Livro object = (Livro)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
