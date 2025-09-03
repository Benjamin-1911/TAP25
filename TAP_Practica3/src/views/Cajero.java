package views;
import controllers.CajeroController;
import models.CajeroModel;

public class Cajero {
    public static void main (String[] args){
    CajeroModel model = new CajeroModel();
    CajeroView view = new CajeroView();
    CajeroController controllers = new CajeroController(model, view);
    controllers.iniciarSistema();
    }
}
