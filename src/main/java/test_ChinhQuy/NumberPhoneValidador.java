package test_ChinhQuy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhoneValidador {
	/*
	 * String regex = "^0[0-9]{9}$";

	1.  ^: Điểm bắt đầu của chuỗi.
	2.  0: Bắt buộc phải có số 0 ở đầu chuỗi.
	3. [0-9]: Ký tự tiếp theo có thể là bất kỳ số nào từ 0 đến 9.
	4. {9}: 9 ký tự số (tổng cộng tối đa 10 ký tự).
	5 . $: Điểm kết thúc của chuỗi.
	 */
	public static boolean validateName(String name) {
		String pattern = "^0[0-9]{9}$";


		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(name);

		return matcher.matches();

	}
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
                System.out.println("Hợp lệ!");
            } else {
                System.out.println("Không hợp lệ. Vui lòng thử lại.");
            }
        }

        System.out.println("Kết thúc chương trình.");

	}

}
