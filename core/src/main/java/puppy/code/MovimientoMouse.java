package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class MovimientoMouse implements EstrategiaMovimiento {
    @Override
    public void mover(Rectangle bucket, float velocidad) {
        float mouseX = Gdx.input.getX();
        bucket.x = mouseX - bucket.width / 2;

        // Mantener dentro de los límites
        if (bucket.x < 0) bucket.x = 0;
        if (bucket.x > 800 - 64) bucket.x = 800 - 64;
    }
}
