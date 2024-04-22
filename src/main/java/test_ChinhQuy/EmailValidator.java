package test_ChinhQuy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static boolean validateName(String name) {
		String pattern = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$";


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
	/*
	 * String regex = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$";
	1.  ^ và $ đại diện cho sự khớp từ đầu đến cuối chuỗi.
	2.  [A-Za-z0-9]+ đại diện cho một hoặc nhiều ký tự chữ thường, hoa hoặc số ở phần trước dấu '@'.
	3.  @ đại diện cho ký tự '@' đứng đầu ở giữa.
	4.  [A-Za-z0-9]+ đại diện cho một hoặc nhiều ký tự chữ thường, hoa hoặc số sau dấu '@'.
	5.  \\. đại diện cho ký tự dấu chấm, nhưng bạn cần phải tránh việc nó bị xem như một ký tự thoát ngược trong chuỗi regex bằng cách sử dụng \\ để thể hiện ký tự dấu chấm trong regex.
	6.  [A-Za-z]{2,} đại diện cho ít nhất hai ký tự chữ thường hoặc hoa sau dấu chấm. Bạn có thể điều chỉnh số 2 thành số khác nếu bạn muốn ít nhất 3 hoặc nhiều ký tự sau dấu chấm.
	7.  $ kết thúc chuỗi
	 */
}
