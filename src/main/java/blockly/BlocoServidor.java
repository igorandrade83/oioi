package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BlocoServidor {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// BlocoServidor
public static Var LoginUsuario() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), cronapi.util.Operations.getCurrentUserName());
    return cronapi.util.Operations.getCurrentUserName();
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var AlunoLogado() throws Exception {
 return new Callable<Var>() {

   private Var ConsultaAluno = Var.VAR_NULL;

   public Var call() throws Exception {
    ConsultaAluno = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.login = :login"),Var.valueOf("login",cronapi.util.Operations.getCurrentUserName()));
    System.out.println(cronapi.text.Operations.getLettersFromStartToFromStart(ConsultaAluno,Var.valueOf(6),Var.valueOf(42)).getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var ReservasUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return cronapi.database.Operations.query(Var.valueOf("app.entity.Reserva"),Var.valueOf("select r from Reserva r where r.user.login = :userLogin"),Var.valueOf("userLogin",cronapi.util.Operations.getCurrentUserName()));
   }
 }.call();
}

}

