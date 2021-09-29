package task1Lv2OOPL2;

public class UpDownTransformer extends InverseTransformer {

	@Override
	public String transform(String text) {
		StringBuilder str = new StringBuilder(text);

		for (int i = 0; i < str.length(); i++) {

			if (i % 2 == 0) {
				str.replace(i, i + 1, str.substring(i, i + 1).toUpperCase());

			} else {
				str.replace(i, i + 1, str.substring(i, i + 1).toLowerCase());
			}

		}
		return str.toString();
	}

}
