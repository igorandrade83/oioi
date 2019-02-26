package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela RESERVA
 * @generated
 */
@Entity
@Table(name = "\"RESERVA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Reserva")
public class Reserva implements Serializable {

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
  @ManyToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_livro", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Livro livro;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "data_reserva", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataReserva = new Date(System.currentTimeMillis());

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "data_emprestimo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataEmprestimo;

  /**
  * @generated
  */
  @Column(name = "teste", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String teste;

  /**
   * Construtor
   * @generated
   */
  public Reserva(){
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
  public Reserva setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public Reserva setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * Obtém livro
   * return livro
   * @generated
   */
  
  public Livro getLivro(){
    return this.livro;
  }

  /**
   * Define livro
   * @param livro livro
   * @generated
   */
  public Reserva setLivro(Livro livro){
    this.livro = livro;
    return this;
  }

  /**
   * Obtém dataReserva
   * return dataReserva
   * @generated
   */
  
  public java.util.Date getDataReserva(){
    return this.dataReserva;
  }

  /**
   * Define dataReserva
   * @param dataReserva dataReserva
   * @generated
   */
  public Reserva setDataReserva(java.util.Date dataReserva){
    this.dataReserva = dataReserva;
    return this;
  }

  /**
   * Obtém dataEmprestimo
   * return dataEmprestimo
   * @generated
   */
  
  public java.util.Date getDataEmprestimo(){
    return this.dataEmprestimo;
  }

  /**
   * Define dataEmprestimo
   * @param dataEmprestimo dataEmprestimo
   * @generated
   */
  public Reserva setDataEmprestimo(java.util.Date dataEmprestimo){
    this.dataEmprestimo = dataEmprestimo;
    return this;
  }

  /**
   * Obtém teste
   * return teste
   * @generated
   */
  
  public java.lang.String getTeste(){
    return this.teste;
  }

  /**
   * Define teste
   * @param teste teste
   * @generated
   */
  public Reserva setTeste(java.lang.String teste){
    this.teste = teste;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Reserva object = (Reserva)obj;
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
