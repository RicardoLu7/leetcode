public class T24 {
    public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int start = 0;// 最长回文的起始位置
            int maxLength = 1;// 最长回文的长度

            for (int i = 0; i < s.length(); i++){
                // 以当前字符为中心（奇数长度回文）
                int len1 = expandFromCenter(s,i,i);
                // 以当前字符和下一个字符为中心（偶数长度回文）
                int len2 = expandFromCenter(s,i,i + 1);
                // 取两种情况的较大值
                int len = Math.max(len1, len2);

                // 如果找到更长的回文，更新起始位置和长度
                if (len > maxLength){
                    maxLength = len;
                    start = i - (len - 1) / 2;
            }
        }
        return s.substring(start,start + maxLength);


    }

    // 从中心向两边扩展，返回回文的长度
    private int expandFromCenter(String s, int left, int right) {
        // 向两边扩展，直到字符不匹配或超出边界
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 返回回文的长度（right - left - 1）
        return right - left - 1;
    }
}
