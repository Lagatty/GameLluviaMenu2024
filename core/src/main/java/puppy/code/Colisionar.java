package puppy.code;
import com.badlogic.gdx.math.Rectangle;

//interfaz para definir objetos que colisionan en el juego, tarro y gota*

interface Colisionable {
        //Obtiene el área de colisión del objeto
        Rectangle getArea();
        boolean colisionaCon(Colisionable otro);
}
