package puppy.code;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaBuena extends Gota {
    private Sound sonido;

    public GotaBuena(Texture textura, float x, float y, Sound sonido) {
        super(textura, x, y);
        this.sonido = sonido;
    }

    @Override
    protected void aplicarEfecto(Tarro tarro) {
        tarro.sumarPuntos(10);
        sonido.play();
    }
}
