import java.util.Random;
public class Driver
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        double randX = rand.nextInt(25, 475);
        double randY = rand.nextInt(25, 275);
        GameArena arena = new GameArena(500, 300);
        UFO ufo = new UFO(200, 200);
        Text txt = new Text("Score: 0", 20, 400, 25, "WHITE");
        Cow cow = new Cow(randX, randY);
        arena.addText(txt);

        ufo.addTo(arena);
        cow.addCow(arena);

        int count = 0;
        int score = 0;

        while(true)
        {
            //Movement
            if(arena.letterPressed('w')){
                ufo.move(0, -10);
            }else if(arena.letterPressed('a')){
                ufo.move(-10, 0);
            } else if(arena.letterPressed('s')){
                ufo.move(0, 10);
            } else if(arena.letterPressed('d')){
                ufo.move(10, 0);
            }

            //Flashing
            if(count < 20){
                count++;
            } else {
                ufo.flash();
                count = 0;
            }

            //Cow Detection
            if(ufo.checkCollisions(cow)){
                arena.clearGameArena();
                score++;
                double randXco = rand.nextInt(25, 475);
                double randYco = rand.nextInt(25, 275);
                //cow.moveTo(randXco, randYco);
                cow = new Cow(randXco, randYco);
                txt.setText("Score:" + score);
                arena.addText(txt);
                ufo.addTo(arena);
                cow.addCow(arena);
            }

            //Pause
            arena.pause();
        }
    }
}
