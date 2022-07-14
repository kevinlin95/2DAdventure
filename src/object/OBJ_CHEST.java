package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_CHEST extends SuperObject{

    public OBJ_CHEST(){
        name = "Chest";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Object/chest.png")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
