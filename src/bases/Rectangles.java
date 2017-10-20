package bases;

public class Rectangles {
     public int x;
     public int y;
     public int width;
     public int height;
     public Rectangles (int x, int y, int width, int height){
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
     }
     public Rectangles check(){
         return new Rectangles(x,y,width,height);

     }
     public static boolean checkOverLap(Rectangles a, Rectangles b){
         if (a.x > b.x || a.y > b.y) {
             return checkOverLap(a, b);
         }
         if (a.x + a.width < b.x || a.y + a.height < b.y) {
             return false;
         }
         if (a.x + a.width > b.x + b.width && a.y + a.height > b.y + b.height){
             return false;
         }
         return true;
     }
}
