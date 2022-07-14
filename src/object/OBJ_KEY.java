package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_KEY extends SuperObject {

    // Objects to add from Super Object Array.
    public OBJ_KEY(){
        name = "Key";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Object/key.png")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
