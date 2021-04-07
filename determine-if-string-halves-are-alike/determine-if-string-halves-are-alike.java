class Solution {
    public boolean halvesAreAlike(String s) {
        return s.substring(0, s.length() / 2).toLowerCase().replaceAll("[aeoui]", "").length()                == s.substring(s.length() / 2).toLowerCase().replaceAll("[aeoui]", "").length();
    }
}