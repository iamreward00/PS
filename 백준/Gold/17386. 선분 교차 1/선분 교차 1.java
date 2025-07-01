import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException  {

    int ax,ay,bx,by,cx,cy,dx,dy;
    ax = ay = bx = by = cx = cy = dx = dy = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
      
    st = new StringTokenizer(br.readLine());
    ax = Integer.parseInt(st.nextToken());
    ay = Integer.parseInt(st.nextToken());
    bx = Integer.parseInt(st.nextToken());
    by = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    cx = Integer.parseInt(st.nextToken());
    cy = Integer.parseInt(st.nextToken());
    dx = Integer.parseInt(st.nextToken());
    dy = Integer.parseInt(st.nextToken());
    if(CCW(ax,ay,bx,by,cx,cy) * CCW(ax,ay,bx,by,dx,dy) < 0 && CCW(cx,cy,dx,dy,ax,ay) * CCW(cx,cy,dx,dy,bx,by) < 0){
      System.out.println(1);
    }
    else{
      System.out.println(0);
    }
  }
  
  public static int CCW(int ax, int ay, int bx, int by, int cx, int cy){
    long ccw = Long.valueOf((bx - cx)) * (ay - by) - Long.valueOf((by - cy)) * (ax - bx);

    if(ccw > 0){
      return -1;
    }
    else if(ccw < 0) { 
      return 1;
    }
    else {
      return 0;
    }
  }
}
