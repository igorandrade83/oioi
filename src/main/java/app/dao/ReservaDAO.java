package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("ReservaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ReservaDAO extends JpaRepository<Reserva, java.lang.String> {

  /**
   * Obtém a instância de Reserva utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Reserva entity WHERE entity.id = :id")
  public Reserva findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Reserva utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Reserva entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM Reserva entity WHERE entity.user.id = :id")
  public Page<Reserva> findReservasByUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key livro
   * @generated
   */
  @Query("SELECT entity FROM Reserva entity WHERE entity.livro.id = :id")
  public Page<Reserva> findReservasByLivro(@Param(value="id") java.lang.String id, Pageable pageable);

}
