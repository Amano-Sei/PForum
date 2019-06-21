package sei.amano.bean;

import java.util.ArrayList;
//经过思考这个bean要作为废案了
public class BlockCategoryInBlock {
	private Block block;
	private ArrayList<BlockCategory> blockcategories;
	public BlockCategoryInBlock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlockCategoryInBlock(Block block, ArrayList<BlockCategory> blockcategories) {
		super();
		this.block = block;
		this.blockcategories = blockcategories;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	public ArrayList<BlockCategory> getBlockcategories() {
		return blockcategories;
	}
	public void setBlockcategories(ArrayList<BlockCategory> blockcategories) {
		this.blockcategories = blockcategories;
	}
}
