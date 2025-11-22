package puppy.code;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import puppy.code.EstrategiaMovimiento;

public class movimientoTeclado implements EstrategiaMovimiento {
    @Override
    public void mover(Rectangle bucket, float velocidad) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            bucket.x -= velocidad * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            bucket.x += velocidad * Gdx.graphics.getDeltaTime();

        // Mantener dentro de los límites
        if (bucket.x < 0) bucket.x = 0;
        if (bucket.x > 800 - 64) bucket.x = 800 - 64;
    }
}
