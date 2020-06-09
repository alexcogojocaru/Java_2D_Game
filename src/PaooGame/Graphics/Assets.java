package PaooGame.Graphics;

import java.awt.image.BufferedImage;
import java.nio.BufferOverflowException;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage soil;
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage townGrass;
    public static BufferedImage townGrassDestroyed;
    public static BufferedImage townSoil;
    public static BufferedImage water;
    public static BufferedImage rockUp;
    public static BufferedImage rockDown;
    public static BufferedImage rockLeft;
    public static BufferedImage rockRight;
    public static BufferedImage tree;

    public static BufferedImage blankTile;
    public static BufferedImage hero;
    public static BufferedImage groundTile;
    public static BufferedImage crackedGroundTile;
    public static BufferedImage leftWall;
    public static BufferedImage rightWall;
    public static BufferedImage wall;
    public static BufferedImage heartFull;
    public static BufferedImage heartHalf;
    public static BufferedImage heartEmpty;
    public static BufferedImage chestOpen;
    public static BufferedImage chestHalfOpen;
    public static BufferedImage chestClosed;
    public static BufferedImage bottomWall;
    public static BufferedImage monster;
    public static BufferedImage sword;
    public static BufferedImage downWall;
    public static BufferedImage skull;
    public static BufferedImage potion;

    public static BufferedImage[] heroAnimation;
    public static BufferedImage[] zombieAnimation;
    public static BufferedImage[] coinAnimation;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/dungeon_sprite.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.

        heroAnimation = new BufferedImage[4];
        heroAnimation[0] = sheet.crop(8, 4, 16, 32);
        heroAnimation[1] = sheet.crop(9, 4, 16, 32);
        heroAnimation[2] = sheet.crop(10, 4, 16, 32);
        heroAnimation[3] = sheet.crop(11, 4, 16, 32);

        zombieAnimation = new BufferedImage[4];
        zombieAnimation[0] = sheet.crop(23, 12, 16, 32);
        zombieAnimation[1] = sheet.crop(24, 12, 16, 32);
        zombieAnimation[2] = sheet.crop(25, 12, 16, 32);
        zombieAnimation[3] = sheet.crop(26, 12, 16, 32);

        coinAnimation = new BufferedImage[2];
        coinAnimation[0] = sheet.crop(18, 17, 8, 8);
        coinAnimation[1] = sheet.crop(19, 17, 8, 8);

        blankTile = sheet.crop(0, 0);
        hero = sheet.crop(8, 4, 16, 32);
        groundTile = sheet.crop(1, 4);
        crackedGroundTile = sheet.crop(2, 4);
        rightWall = sheet.crop(0, 8);
        leftWall = sheet.crop(1, 8);
        downWall = sheet.crop(2, 8);
        wall = sheet.crop(1, 1);
        heartFull = sheet.crop(18, 16);
        heartHalf = sheet.crop(19, 16);
        heartEmpty = sheet.crop(20, 16);
        chestOpen = sheet.crop(17, 14);
        potion = sheet.crop(18, 14);
        bottomWall = sheet.crop(2, 10);
        monster = sheet.crop(23, 12, 16, 32);
        skull = sheet.crop(14, 14);

        grass = sheet.crop(0, 0);
        soil = sheet.crop(1, 0);
        water = sheet.crop(2, 0);
        mountain = sheet.crop(3, 0);
        townGrass = sheet.crop(0, 1);
        townGrassDestroyed = sheet.crop(1, 1);
        townSoil = sheet.crop(2, 1);
        tree = sheet.crop(3, 1);
        heroLeft = sheet.crop(0, 2);
        heroRight = sheet.crop(1, 2);
        rockUp = sheet.crop(2, 2);
        rockDown = sheet.crop(3, 2);
        rockLeft = sheet.crop(0, 3);
        rockRight = sheet.crop(1, 3);
        sword = sheet.crop(20, 5, 16, 32);
    }
}
