package puppy.code;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;

public abstract class Gota implements Colisionable {
    protected Rectangle area;
    protected Texture textura;

    public Gota(Texture textura, float x, float y) {
        this.textura = textura;
        area = new Rectangle(x, y, 64, 64);
    }

    // Template method
    public final boolean actualizar(Tarro tarro) {
        mover();
        if (haCaido()) return false;
        if (colisionaCon(tarro)) {
            aplicarEfecto(tarro);
            return false; // eliminar después de aplicar efecto
        }
        return true; // sigue viva
    }

    protected void mover() {

        area.y -= 300 * Gdx.graphics.getDeltaTime();
    }

    protected boolean haCaido() {

        return area.y + area.height < 0;
    }

    // Implementación de Colisionable
    @Override
    public Rectangle getArea() {
        return area;
    }

    @Override
    public boolean colisionaCon(Colisionable otro) {
        return area.overlaps(otro.getArea());
    }

    public void dibujar(SpriteBatch batch) {
        batch.draw(textura, area.x, area.y);
    }

    // Método abstracto
    protected abstract void aplicarEfecto(Tarro tarro);
}
