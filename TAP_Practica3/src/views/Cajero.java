package views;
import controllers.CajeroController;
import models.CajeroModel;

/**
 *
 * @author usuario
 */
public class Cajero {

    /**
     *
     * @param args
     */
    public static void main (String[] args){
    CajeroModel model = new CajeroModel();
    CajeroView view = new CajeroView();
    CajeroController controllers = new CajeroController(model, view);
    controllers.iniciarSistema();
    }
}
