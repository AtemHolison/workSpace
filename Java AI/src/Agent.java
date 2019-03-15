import java.awt.image.BufferedImage;

public class Agent {
	private BufferedImage mapData;
	private BufferedImage pathData;
	private int x;
	private int y;
	private int drawClr;

	public Agent(BufferedImage mapData, BufferedImage pathData, int x, int y, int drawClr) {
		this.mapData = mapData;
		this.pathData = pathData;
		this.x = x;
		this.y = y;
		this.drawClr = drawClr;
		// this.pathData.setRGB(this.x,this.y,this.drawClr);

	}

	public int getEvaluation() {
		return this.mapData.getRGB(this.x, this.y);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void climb() {
		this.pathData.setRGB(this.x, this.y, this.drawClr);

		int left = 0, right = 0, up = 0, down = 0;
		// Looking around
		if (x > 0)
			left = mapData.getRGB((x - 1) % mapData.getWidth(), y);
		else
			left = mapData.getRGB(mapData.getWidth() - 1, y);

		right = mapData.getRGB((x + 1) % mapData.getWidth(), y);

		if (y > 0)
			up = mapData.getRGB(x, (y - 1) % mapData.getHeight());
		else
			up = mapData.getRGB(x, mapData.getHeight() - 1);

		down = mapData.getRGB(x, (y + 1) % mapData.getHeight());

		// Checking the direction to go and then moving
		if (left > right)
		{
			this.x--;
			if (this.x<0)
				this.x=mapData.getWidth()-1;
		}
		if (right > left)
			this.x=(this.x+1)%mapData.getWidth();
		
		if (up > down)
		{
			this.y--;
			if (this.y<0)
				this.y=mapData.getHeight()-1;
		}
		if (down > up)
			this.y=(this.y+1)%mapData.getHeight();
	}

}
