package com.completedsa.java.javaAdvanced;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * A regular expression is a sequence of characters that forms a search pattern.
 * When you search for data in a text, you can use this search pattern to describe what you are searching for.
 */
public class RegularExpressions {
    public static void main (String[] args) {
        // Pattern Class - Defines a pattern (to be used in a search)
        Pattern pattern = Pattern.compile("w3school", Pattern.CASE_INSENSITIVE);

        // Matcher Class - Used to search for the pattern
        Matcher matcher = pattern.matcher("Visit W3school");

        boolean matchFound = matcher.find();

        if (matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }

        /*
        ===============================
        1. KÝ TỰ CƠ BẢN
        ===============================

        cat         → Tìm chính xác chuỗi "cat"
        .           → Bất kỳ MỘT ký tự nào
        [abc]       → Một ký tự là a, b hoặc c
        [^abc]      → Một ký tự KHÔNG phải a, b hoặc c
        [a-z]       → Một ký tự từ a đến z (chữ thường)
        [A-Z]       → Một ký tự từ A đến Z (chữ hoa)
        \d          → Một số (0–9)
        \D          → Không phải số
        \w          → Chữ cái, số, hoặc dấu gạch dưới "_"
        \W          → Không phải chữ cái, số hoặc "_"
        \s          → Khoảng trắng (space, tab, xuống dòng)
        \S          → Không phải khoảng trắng
        \b          → Ranh giới từ (bắt đầu hoặc kết thúc một từ)
        \B          → Không phải ranh giới từ
        ^           → Bắt đầu chuỗi
        $           → Kết thúc chuỗi
        */

        /*
        ===============================
        2. SỐ LẦN LẶP
        ===============================

        *           → Lặp 0 hoặc nhiều lần
        +           → Lặp 1 hoặc nhiều lần
        ?           → Lặp 0 hoặc 1 lần
        {n}         → Lặp đúng n lần
        {n,}        → Lặp ít nhất n lần
        {n,m}       → Lặp từ n đến m lần
        */

        /*
        ===============================
        3. NHÓM VÀ LỰA CHỌN
        ===============================

        (abc)       → Nhóm ký tự hoặc regex
        a|b         → a HOẶC b
        (?:abc)     → Nhóm nhưng không lưu kết quả (non-capturing group)
        */

        /*
        ===============================
        4. CỜ (FLAGS) - THAY ĐỔI CÁCH HOẠT ĐỘNG
        ===============================

        (?i)        → Không phân biệt hoa/thường
        (?m)        → Chế độ nhiều dòng (multi-line)
        (?s)        → Cho phép "." match cả ký tự xuống dòng
        (?x)        → Cho phép regex có khoảng trắng để dễ đọc
        */

        /*
        ===============================
        5. VÍ DỤ KẾT HỢP
        ===============================

        (?i)cats?               → Match "cat", "cats", "Cat", "CATS"
        \d{3}-\d{2}-\d{4}       → Định dạng số kiểu "123-45-6789"
        \b[A-Z][a-z]+\b         → Từ bắt đầu bằng chữ hoa, sau đó là chữ thường
        */
    }
}
