
public class SmallKiller extends KillerObj {
	
	public int SIZE;
    public static int INIT_POS_X = 0;
    public static int INIT_POS_Y = 0;
    public static int INIT_VEL_X = 0;
    public static int INIT_VEL_Y = 2;

	public SmallKiller(int courtWidth, int courtHeight, int size) {
	 super(INIT_VEL_X, INIT_VEL_Y, INIT_POS_X, INIT_POS_Y, size, size, courtWidth, courtHeight);
		this.SIZE = size;
	    INIT_POS_X += 30;
		if(INIT_POS_X >= courtWidth){
    		INIT_POS_X = 0;
    	}
	}
	
	public int getSize(){
		return this.SIZE;
	}
	@Override
	public void resize(int factor) {
		this.SIZE = (int) (this.SIZE / factor);

	}
	
	

}
