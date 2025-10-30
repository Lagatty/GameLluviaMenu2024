package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {
    private Array<Gota> gotas;
    private long lastDropTime;
    private Texture gotaBuena;
    private Texture gotaMala;
    private Sound dropSound;
    private Music rainMusic;

    public Lluvia(Texture gotaBuena, Texture gotaMala, Sound ss, Music mm) {
        this.gotaBuena = gotaBuena;
        this.gotaMala = gotaMala;
        this.dropSound = ss;
        this.rainMusic = mm;
    }

    public void crear() {
        gotas = new Array<Gota>();
        crearGotaDeLluvia();
        rainMusic.setLooping(true);
        rainMusic.play();
    }

    private void crearGotaDeLluvia() {
        float x = MathUtils.random(0, 800 - 64);
        float y = 480;

        if (MathUtils.randomBoolean(0.5f)) {
            gotas.add(new GotaBuena(gotaBuena, x, y, dropSound));
        } else {
            gotas.add(new GotaMala(gotaMala, x, y));
        }

        lastDropTime = TimeUtils.nanoTime();
    }

    public boolean actualizarMovimiento(Tarro tarro) {
        if (TimeUtils.nanoTime() - lastDropTime > 100000000) {
            crearGotaDeLluvia();
        }

        for (int i = gotas.size - 1; i >= 0; i--) {
            Gota g = gotas.get(i);
            boolean sigueViva = g.actualizar(tarro);
            if (!sigueViva) {
                gotas.removeIndex(i);
                if (tarro.getVidas() <= 0)
                    return false; // Game Over
            }
        }
        return true;
    }

    public void actualizarDibujoLluvia(SpriteBatch batch) {
        for (Gota g : gotas) {
            g.dibujar(batch);
        }
    }

    public void destruir() {
        dropSound.dispose();
        rainMusic.dispose();
    }

    public void pausar() {
        rainMusic.stop();
    }

    public void continuar() {
        rainMusic.play();
    }
}
