package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class NumBloco {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// numBloco
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item = Var.valueOf(40);
    for (long count = 0; count < Var.valueOf(2000).getObjectAsLong();count++) {
            cronapi.database.Operations.insert(Var.valueOf("app.entity.num"),Var.valueOf("num",item));
        item = cronapi.math.Operations.sum(item,Var.valueOf(2));
    } // end for
    return Var.VAR_NULL;
   }
 }.call();
}

}

