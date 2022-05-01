package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Path;

public class TileManager {

    GamePanel gp;
    Tile[] tile;

    int[][] mapTileNum;

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[20];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }
    public void getTileImage(){

        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("/Users/kevinsmacbookair/JavaMethods/HumansVsGoblinsV2/src/res/tiles/newVersion/grass00.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File("/Users/kevinsmacbookair/JavaMethods/HumansVsGoblinsV2/src/res/tiles/NewVersion/road05.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(new File("/Users/kevinsmacbookair/JavaMethods/HumansVsGoblinsV2/src/res/tiles/newVersion/road06.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(new File("/Users/kevinsmacbookair/JavaMethods/HumansVsGoblinsV2/src/res/tiles/NewVersion/road11.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(new File("/Users/kevinsmacbookair/JavaMethods/HumansVsGoblinsV2/src/res/tiles/NewVersion/road12.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/TileMap.rtf");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();

                while(col < gp.maxScreenCol){
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNum = mapTileNum[col][row]; // TileMap.rtf

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }

}
