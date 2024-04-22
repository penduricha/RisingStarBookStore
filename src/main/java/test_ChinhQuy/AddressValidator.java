package test_ChinhQuy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class AddressValidator {

	public static void main(String[] args) {
		String input = "34/23 Trần Sa, Hà Nội.";
		
        // Sử dụng biểu thức chính quy để kiểm tra chuỗi
        String regex = "^[a-zA-Z0-9,./\\p{L} ]*$";
        		
        //Chứa chữ và số và kí tự "/" có hoặc ko, ko có kí tự đặc biệt	
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Chuỗi hợp lệ.");
        } else {
            System.out.println("Chuỗi không hợp lệ.");
        }

	}

}
/*^[a-zA-Z0-9,.\p{L} ]*$
	Ở đây:
	
	^ đánh dấu điểm bắt đầu của chuỗi.
	[a-zA-Z0-9,.\p{L} ]* là một tập hợp các ký tự cho phép:
	a-zA-Z cho phép chữ cái in hoa và thường.
	0-9 cho phép chữ số.
	,. cho phép dấu phẩy (,) và dấu chấm (.).
	\p{L} cho phép ký tự tiếng Việt.
	cho phép khoảng trắng (dấu cách).
	* cho phép zero hoặc nhiều ký tự từ tập hợp trước đó.
	$ đánh dấu điểm kết thúc của chuỗi.
 *
 */
