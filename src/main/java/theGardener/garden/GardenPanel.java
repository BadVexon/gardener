package theGardener.garden;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.plots.RegularPlot;
import theGardener.garden.structures.AbstractPlant;
import theGardener.util.TextureLoader;

import java.util.ArrayList;

public class GardenPanel {
    public static ArrayList<ArrayList<AbstractPlot>> map;
    public static int HEIGHT = 4;
    public static int WIDTH = 4;
    public static Texture grid = TextureLoader.getTexture(ezpath("Grid"));
    public static boolean shouldRender = false;

    public static final float offset = (64F + 6F) * Settings.scale;

    public static float X_POS = Settings.WIDTH / 2F - offset * (WIDTH + 1) / 2F;
    public static float Y_POS = (Settings.HEIGHT / 1.75F);

    public static AbstractPlant hoverPiece = null;
    public static AbstractPlot hoverPlot = null;
    public static float hoverX;
    public static float hoverY;
    public static boolean renderHover = false;
    public static boolean renderPlot = false;

    public static void init() {
        initMap();
        shouldRender = true;
    }

    public static void render(SpriteBatch sb) {
        for (ArrayList<AbstractPlot> array : map) {
            for (AbstractPlot t : array) {
                t.render(sb);
            }
        }
        if (renderHover) {
            hoverPiece.render(hoverX, hoverY, sb);
        }
        if (renderPlot) {
            hoverPlot.x = hoverX;
            hoverPlot.y = hoverY;
            hoverPlot.render(sb);
        }
        sb.draw(grid, X_POS, Y_POS, grid.getWidth() / 2F, grid.getHeight() / 2F, grid.getWidth(), grid.getHeight(), Settings.scale, Settings.scale, 0, 0, 0, grid.getWidth(), grid.getHeight(), false, false);
    }

    public static void update() {
        for (ArrayList<AbstractPlot> array : map) {
            for (AbstractPlot t : array) {
                t.update();
            }
        }
    }

    public static String ezpath(String s) {
        return "gardenmod/images/ui/" + s + ".png";
    }

    public static void initMap() {
        map = new ArrayList<>();
        float dY = Y_POS + (6f * Settings.scale);

        for (int y = 0; y < HEIGHT; ++y) {// 84
            float dX = X_POS + (6f * Settings.scale);
            ArrayList<AbstractPlot> row = new ArrayList<>();// 85

            for (int x = 0; x < WIDTH; ++x) {// 86
                row.add(new RegularPlot(y, x, dX, dY));// 87
                dX += offset;
            }

            map.add(row);// 89
            dY += offset;
        }
    }

    public static void setSpace(AbstractPlot p, AbstractPlot summon) {
        int bx = p.boardx;
        int by = p.boardy;
        summon.setPosition(p.x, p.y);
        GardenPanel.map.get(bx).set(by, summon);
        summon.boardx = bx;
        summon.boardy = by;
    }

    public static AbstractPlant getRandomPlant() {
        ArrayList<AbstractPlant> pList = new ArrayList<>();
        for (ArrayList<AbstractPlot> p : map) {
            for (AbstractPlot q : p) {
                if (q.hasPlant()) pList.add(q.myPlant);
            }
        }
        return pList.get(AbstractDungeon.cardRandomRng.random(pList.size() - 1));
    }
}
