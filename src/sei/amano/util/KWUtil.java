package sei.amano.util;

public class KWUtil {
	//突然想起来到split里面是正则来着，就做一下简单的过滤
	//然而这个要双倍的反斜杠(一开始懵逼了好半天才意识到...←这暴露了你没有java的正则经验
	//↑其实我完全没有正则经验(不过想抓住每次可以用的机会复习练习

	//在第二次重复代码的时候决定把它util化
	//意识到在传入之后进行过滤可能会浪费性能不如传入过滤好的，所以从dao里面拿出去了，大概会交给servelt和filter

	//2019-6-20 晚饭前
	//用了差不多两天完成了9个dao和初步设计...感觉进度差不多有10%~20%了，好在自己最后只打算交50%左右完成度的东西
	//主要在敲的过程中产生了好多想法...但是设计本身就已经被改了好多次了，准备等初版完成之后再说加入新想法什么的
	//顺带听说某dalao写了一堆jsp的"复杂"工程，是呀我就是酸了...
	//为什么就那么点三脚猫功夫都能那样自信啊←明明你自己也是个自大的家伙
	//与其说我希望别人觉得我很厉害，不如说我只是想变得很厉害吧，虽然现在还是弱渣（（（
	//说实话，朝着完全完成度做就是我吐血熬夜完全不复习都做不完...
	//↑说的你好像准备好好复习一样（
	//突然发觉好像饭卡丢了...先找饭卡去了...
	public static String getRealkey(String keywords) {
		String ans = "";
		for(String s : keywords.split("[\\\\s%\\\\\\\"\\\\\\'\\\\|\\\\\\\\]"))
			if(!s.equals(""))
				ans = ans.equals("")?s:ans+" "+s;
		return ans;
	}
}
