package test_ChinhQuy;

import java.util.Scanner;
import java.util.regex.*;

public class NameValidator {

	public static boolean validateName(String name) {
		String pattern = "^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)*$";


		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(name);

		return matcher.matches();

	}
	/*
	 * Giải thích biểu thức chính quy:

		^: Bắt đầu của chuỗi.
		[\\p{Lu}]: Kí tự đầu tiên phải là một chữ cái viết hoa.
		[\\p{Ll}]+: Theo sau bởi một chuỗi các chữ cái viết thường.
		(\\s[\\p{Lu}][\\p{Ll}]+)*: Có thể có khoảng trắng và một chuỗi tương tự như trước đó.
		$: Kết thúc của chuỗi.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập tên (hoặc gõ 'exit' để thoát): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            boolean isValid = validateName(input);
            if (isValid) {
                System.out.println("Tên hợp lệ!");
            } else {
                System.out.println("Tên không hợp lệ. Vui lòng thử lại.");
            }
        }

        System.out.println("Kết thúc chương trình.");
    }

}