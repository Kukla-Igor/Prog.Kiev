package task1Lv2OOPL2;

public class InverseTransformer extends TextTransformer{
	
	@Override
	public  String transform(String text) {
		return new StringBuilder(text).reverse().toString();
	}

}
