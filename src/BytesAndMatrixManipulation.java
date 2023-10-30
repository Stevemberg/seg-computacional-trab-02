import java.util.ArrayList;
import java.util.Arrays;
import java.util.HexFormat;

public class BytesAndMatrixManipulation {

	public Byte[][] convertBytesToMatrix(Byte[] bytes, boolean isAES) {
		Byte[][] byteMatrix = new Byte[4][4];
		int index = 0;

		for (int i = 0; i < byteMatrix.length; i++) {
			for (int j = 0; j < byteMatrix[i].length; j++) {
				if (isAES) {
					byteMatrix[j][i] = bytes[index];
				} else {
					byteMatrix[i][j] = bytes[index];
				}
				index++;
			}
		}
		return byteMatrix;
	}

	public Byte[][] convertIntegerToMatrix(ArrayList<Integer> integers, boolean isAES) {
		Byte[] bytes = new Byte[0];
		for (Integer integer : integers) {
			bytes = Arrays.copyOf(bytes, bytes.length + 1);
			bytes[bytes.length - 1] = integer.byteValue();
		}
		return convertBytesToMatrix(bytes, isAES);
	}

	public Byte[][] convertStringToMAtrix(String str, boolean isAES) {
		return convertIntegerToMatrix(convertStringToDecimal(str, " "), isAES);
	}

	public ArrayList<Byte[][]> convertBytesToArrayList(Byte[] bytes, boolean isAES) {
//		ArrayList<Byte[][]> result = new ArrayList<Byte[][]>();
//		convertBytesToMatrix(bytes, isAES);

		return null;
	}

	public static void printMatrix(Byte[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(HexFormat.of().toHexDigits(matrix[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public static void printMatrix(int[][] matrix) {
		Byte[][] byteMatrix = new Byte[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				byteMatrix[i][j] = Integer.valueOf(matrix[i][j]).byteValue();
			}
		}
		printMatrix(byteMatrix);
	}

	public Integer convertStringToDecimal(String str) {
		return Integer.parseInt(str, 16);
	}

	public ArrayList<Integer> convertStringToDecimal(String str, String delimiter) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		String[] hexadecimals = str.split(delimiter);
		for (int i = 0; i < hexadecimals.length; i++) {
			result.add(convertStringToDecimal(hexadecimals[i]));
		}
		return result;
	}

	public Byte[] convertStringToByteArray(String str) {
		ArrayList<Integer> aux = convertStringToDecimal(str, " ");
		Byte[] result = new Byte[aux.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.valueOf(aux.get(i)).byteValue();
		}
		return result;

	}

	public void printVector(Byte[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(HexFormat.of().toHexDigits(vector[i]));
			if (i < vector.length - 1)
				System.out.print(", ");

		}
		System.out.print("\n");
	}

	public void printVector(int[] vector) {
		printVector(ArrayUtils.convertToByte(vector));
	}

}