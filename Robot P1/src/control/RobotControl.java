package control;

import robot.Robot;

//Robot Assignment for Programming 1 s1 2018
//Adapted by Caspar and Ross from original Robot code in written by Dr Charles Thevathayan
public class RobotControl implements Control {
	// we need to internally track where the arm is
	private int height = Control.INITIAL_HEIGHT;
	private int width = Control.INITIAL_WIDTH;
	private int depth = Control.INITIAL_DEPTH;

	private int[] barHeights;
	private int[] blockHeights;

	private Robot robot;


	// called by RobotImpl
	@Override
	public void control(Robot robot, int barHeightsDefault[], int blockHeightsDefault[])
	{
		this.robot = robot;

		// some hard coded init values you can change these for testing
		this.barHeights = new int[] { 3, 6, 5, 4, 3, 2 };
		this.blockHeights = new int[] { 2,3,2,3,1,1 };

		// bars at dest 1 and dest 2
		int[] destBarHeights = new int[] { 0, 0 };

		// initialise the robot
		robot.init(this.barHeights, this.blockHeights, height, width, depth);

	

		// get the number of blocks to move
		int blockSize = this.blockHeights.length;
		int sourceHeight = getArraySum(this.blockHeights);

		// move block one by one
		for (int i = blockSize - 1; i >= 0; i--)
		{
			// get the block
			int block = this.blockHeights[i];

			// go to the block
			int movingWidth = Control.MAX_WIDTH;
			int heightToBlock = sourceHeight + 1;
			int heightAdjust = adjustToObstacle(heightToBlock, this.barHeights);
			int movingHeight = heightToBlock + heightAdjust;
			int movingDepth = movingHeight - sourceHeight - 1;
			this.moveRobotToHeight(movingHeight);
			this.moveRobotToWidth(movingWidth);
			this.moveRobotToDepth(movingDepth);

			// pick the block and lift
			this.robot.pick();
			this.moveRobotToDepth(0);

			// go to the block destination
			if (block != Control.MAX_BLOCK_HEIGHT)
			{
				movingWidth = block;
				int clearBy = adjustToObstacle(movingHeight - block - Control.MIN_WIDTH, this.barHeights);
				movingHeight += clearBy;
				movingDepth = movingHeight - block - destBarHeights[block - 1];
			} else
			{
				movingWidth = 3;
				int clearBy = adjustToObstacle(movingHeight - block - Control.MIN_WIDTH, this.barHeights);
				movingHeight += clearBy;
				movingDepth = movingHeight - block - this.barHeights[block - 3];
			}

			this.moveRobotToHeight(movingHeight);
			this.moveRobotToWidth(movingWidth);
			this.moveRobotToDepth(movingDepth - Control.MIN_WIDTH);

			// drop the block
			this.robot.drop();
			this.moveRobotToDepth(0);

			// update the bars and source height
			sourceHeight -= block;
			if (block != Control.MAX_BLOCK_HEIGHT)
			{
				destBarHeights[block - 1] += block;
			} else
			{
				// update the other bars
				this.barHeights[block - 3] += block;
			}

		}

		// a simple private method to demonstrate how to control robot
		// note use of constant from Control interface
		// You should remove this method call once you start writing your code

		// ADD ASSIGNMENT PART A METHOD CALL(S) HERE

	}

	private int adjustToObstacle(int h, int[] obstacleArray)
	{
		int ad = 0;
		int maxInArray = getMaxInArray(obstacleArray);
		if (h <= maxInArray)
			ad = maxInArray - h + Control.MIN_WIDTH;

		return ad;
	}

	private int getMaxInArray(int[] arr)
	{
		int max = arr[0];
		for (int n : arr)
		{
			if (n > max)
				max = n;
		}
		return max;
	}

	// helper method to get the sum of an array
	private int getArraySum(int[] arr)
	{
		int sum = 0;
		for (int i : arr)
			sum += i;

		return sum;
	}

	// PZ
	// 1 step: go to block Zi
	private void goToBlock(int blockSize)
	{
		this.robot.lower();// Control.MIN_DEPTH;

	}

	

	private void moveRobotToHeight(int h)
	{
		if (h < Control.MIN_HEIGHT || h > Control.MAX_HEIGHT)
			return;

		if (this.height == h)
			return;

		if (this.height > h)
		{
			int max = this.height - h;
			for (int i = 0; i < max; i++)
				this.robot.down();
		}

		if (this.height < h)
		{
			int max = h - this.height;
			for (int i = 0; i < max; i++)
				this.robot.up();
		}

		this.height = h;
	}

	private void moveRobotToWidth(int w)
	{
		if (w < Control.MIN_WIDTH || w > Control.MAX_WIDTH)
			return;

		if (this.width == w)
			return;

		if (this.width > w)
		{
			int max = this.width - w;
			for (int i = 0; i < max; i++)
				this.robot.contract();
		}

		if (this.width < w)
		{
			int max = w - this.width;
			for (int i = 0; i < max; i++)
				this.robot.extend();
		}

		this.width = w;
	}

	private void moveRobotToDepth(int d)
	{
		if (d < Control.MIN_DEPTH || d > Control.MAX_DEPTH)
			return;

		if (this.depth == d)
			return;

		if (this.depth > d)
		{
			int max = this.depth - d;
			for (int i = 0; i < max; i++)
				this.robot.raise();
		}

		if (this.depth < d)
		{
			int max = d - this.depth;
			for (int i = 0; i < max; i++)
				this.robot.lower();
		}

		this.depth = d;
	}

	// simple example method to help get you started

}
