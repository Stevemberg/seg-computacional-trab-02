import java.util.Arrays;
import java.util.HexFormat;

public class ArrayUtils {
	public static void shift(Byte[] array, int offset) {
		if (offset == 0)
			return;
		if (offset > 0) {
			Byte aux = array[0];
			for (int i = 0; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			}
			array[array.length - 1] = aux;
			shift(array, offset - 1);
		}
		if (offset < 0) {
			Byte aux = array[array.length - 1];
			for (int i = array.length - 1; i > 0; i--) {
				array[i] = array[i - 1];
			}
			array[0] = aux;
			shift(array, offset + 1);
		}
	}

	public static Byte[] apend(Byte[] array1, Byte[] array2) {
		Byte[] result = Arrays.copyOf(array1, array1.length + array2.length);
		for (int i = 0; i < array2.length; i++)
			result[array1.length + i] = array2[i];
		return result;
	}

	public static int[] xor2Vector(Byte[] array, Byte[] array1) {
		if (array.length != array1.length)
			return null;

		int[] result = new int[array.length];
		for (int i = 0; i < result.length; i++)
			result[i] = (array[i] ^ array1[i]) & 0xff;
		return result;
	}

	public static Byte[] convertToByte(int[] array) {
		Byte[] result = new Byte[array.length];
		for (int i = 0; i < result.length; i++)
			result[i] = Integer.valueOf(array[i]).byteValue();
		return result;
	}

	public static int[] convertToInt(Byte[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < result.length; i++)
			result[i] = Byte.toUnsignedInt(array[i]);
		return result;
	}

	public static String convertToString(Byte[] array) {
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < array.length; i++)
			result.append(HexFormat.of().toHexDigits(array[i]));
		return result.toString();
	}

}
