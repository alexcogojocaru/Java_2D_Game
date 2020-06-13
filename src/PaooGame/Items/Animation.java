package PaooGame.Items;

import java.awt.image.BufferedImage;

/*! \class Animation
    \brief Clasa pentru gestionarea animatiilor
 */
public class Animation {
    private int speed;
    private int index;
    private BufferedImage[] frames;
    private long lastTime;
    private long timer;

    /*! \fn Animation(int speed, BufferedImage[] frames)
        \brief Constructorul clasei
     */
    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        this.index = 0;
        lastTime = System.currentTimeMillis();
    }

    /*! \fn public void Update()
     */
    public void Update() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length) {
                index = 0;
            }
        }
    }

    /*! \fn public BufferedImage getCurrentFrame()
        \brief Getter pentru animatia curenta
     */
    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}
