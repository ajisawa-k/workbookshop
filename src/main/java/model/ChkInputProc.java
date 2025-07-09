package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChkInputProc {
    public String chkEmail(String email) {
        String errorMsg = "";
        errorMsg = email.isEmpty() ? "e-mail\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        Pattern p = Pattern.compile("^(([0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*)|(\"[^\"]*\"))@[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*$");
        Matcher m = p.matcher(email);
        errorMsg = errorMsg + (!m.find() ? "e-mail\u306e\u5f62\u5f0f\u304c\u6b63\u3057\u304f\u3042\u308a\u307e\u305b\u3093\n" : "");
        return errorMsg;
    }

    public String chkTel(String tel) {
        String errorMsg = "";
        errorMsg = tel.isEmpty() ? "\u96fb\u8a71\u756a\u53f7\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        Pattern p = Pattern.compile("0\\d{1,4}-\\d{1,4}-\\d{4}");
        Matcher m = p.matcher(tel);
        errorMsg = errorMsg + (!m.find() ? "\u96fb\u8a71\u756a\u53f7\u306e\u5f62\u5f0f\u304c\u6b63\u3057\u304f\u3042\u308a\u307e\u305b\u3093\u3002(\u4f8b:03-5259-0070)\n" : "");
        return errorMsg;
    }

    public String chkL_name(String l_name) {
        String errorMsg = "";
        String MATCH_ZENKAKU = "^[\u3041-\u3093\u30a1-\u30f6\u30fc\u4e00-\u9fa0]+$";
        errorMsg = l_name.isEmpty() ? "(\u6c0f)\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        errorMsg = !l_name.matches(MATCH_ZENKAKU) ? "(\u6c0f)\u304c\u5168\u89d2\u3067\u306f\u3042\u308a\u307e\u305b\u3093\u3002\n" : "";
        return errorMsg;
    }

    public String chkF_name(String f_name) {
        String errorMsg = "";
        String MATCH_ZENKAKU = "^[\u3041-\u3093\u30a1-\u30f6\u30fc\u4e00-\u9fa0]+$";
        errorMsg = (f_name = this.trimString(f_name)).isEmpty() ? "(\u540d)\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        errorMsg = !f_name.matches(MATCH_ZENKAKU) ? "(\u540d)\u304c\u5168\u89d2\u3067\u306f\u3042\u308a\u307e\u305b\u3093\u3002\n" : "";
        return errorMsg;
    }

    public String chkL_name_kana(String l_name_kana) {
        String errorMsg = "";
        l_name_kana = this.trimString(l_name_kana);
        String MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$";
        errorMsg = l_name_kana.isEmpty() ? "(\u30b7)\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        errorMsg = !l_name_kana.matches(MATCH_KATAKANA) ? "(\u30b7)\u304c\u5168\u89d2\u30ab\u30ca\u3067\u3042\u308a\u307e\u305b\u3093\u3002\n" : "";
        return errorMsg;
    }

    public String chkF_name_kana(String f_name_kana) {
        String errorMsg = "";
        String MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$";
        errorMsg = f_name_kana.isEmpty() ? "(\u30e1\u30a4)\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        errorMsg = !f_name_kana.matches(MATCH_KATAKANA) ? "(\u30e1\u30a4)\u304c\u5168\u89d2\u30ab\u30ca\u3067\u3042\u308a\u307e\u305b\u3093\u3002\n" : "";
        return errorMsg;
    }

    public String chkPassword(String password) {
        String errorMsg = "";
        errorMsg = (password = this.trimString(password)).isEmpty() ? "\u30d1\u30b9\u30ef\u30fc\u30c9\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        return errorMsg;
    }

    public String chkPrefecture(String prefecture) {
        String errorMsg = "";
        errorMsg = (prefecture = this.trimString(prefecture)).isEmpty() ? "\u90fd\u9053\u5e9c\u770c\u304c\u9078\u629e\u3055\u308c\u3066\u3044\u307e\u305b\u3093\u3002\n" : errorMsg;
        return errorMsg;
    }

    public String chkCity(String city) {
        String errorMsg = "";
        city = this.trimString(city);
        String MATCH_ZENKAKU = "^[\u3041-\u3093\u30a1-\u30f6\u30fc\u4e00-\u9fa0]+$";
        errorMsg = city.isEmpty() ? "\u5e02\u533a\u753a\u6751\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        errorMsg = !city.matches(MATCH_ZENKAKU) ? "\u5e02\u533a\u753a\u6751\u304c\u5168\u89d2\u3067\u3042\u308a\u307e\u305b\u3093\u3002\n" : "";
        return errorMsg;
    }

    public String chkO_address(String o_address) {
        String errorMsg = "";
        errorMsg = (o_address = this.trimString(o_address)).isEmpty() ? "\u756a\u5730\u30fb\u5efa\u7269\u30fb\u53f7\u5ba4\u304c\u7a7a\u3067\u3059\u3002\n" : errorMsg;
        return errorMsg;
    }

    public String trimString(String str) {
        str = str.replaceAll(" ", "");
        str = str.trim();
        return str;
    }
}
