public class UFO{
    private int x;
    private int y;

    private Ball ballArray[] = {new Ball(x + 15, y, 25, "GREEN"), new Ball(x + 30, y + 10, 20, "GREY"), new Ball(x, y + 10, 20, "GREY"), new Ball(x, y + 10, 5, "GREEN", 2), new Ball(x + 15, y + 10, 5, "GREEN", 2), new Ball(x + 30, y + 10, 5, "GREEN", 2)};
    private Rectangle rect = new Rectangle(x, y, 30, 20, "GREY");

    public void addTo(GameArena g){
        for (Ball ball : ballArray) {
            g.addBall(ball);
        }
        g.addRectangle(rect);
    }

    public UFO(int x, int y){
        this.x = x;
        this.y = y;
        for (Ball ball : ballArray) {
            ball.move(this.x, this.y);
        }
        rect.move(this.x, this.y);
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
        for (Ball ball : ballArray) {
            ball.move(x, y);
        }
        rect.move(x, y);
    }

    public void flash(){
        for (Ball ball : ballArray) {
            if(ball.getColour() == "GREEN"){
                ball.setColour("YELLOW");
            } else if(ball.getColour() == "YELLOW"){
                ball.setColour("GREEN");
            }
        }
    }

    public boolean checkCollisions(Cow cow){
        for (Ball ball : ballArray) {
            if(ball.collides(cow.getCow())){
                return true;
            }
        }
        return false;
    }
}
