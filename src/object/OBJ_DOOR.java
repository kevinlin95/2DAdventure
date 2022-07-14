package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_DOOR extends SuperObject {

    public OBJ_DOOR(){
        name = "Door";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Object/door.png")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
