package sei.amano.bean;

import java.util.ArrayList;
//经过思考这个bean要作为废案了
public class BlockInBlockCategory {
	private BlockCategory blockcategory;
	private ArrayList<Block> blocks;
	public BlockInBlockCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlockInBlockCategory(BlockCategory blockcategory, ArrayList<Block> blocks) {
		super();
		this.blockcategory = blockcategory;
		this.blocks = blocks;
	}
	public BlockCategory getBlockcategory() {
		return blockcategory;
	}
	public void setBlockcategory(BlockCategory blockcategory) {
		this.blockcategory = blockcategory;
	}
	public ArrayList<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}
}
