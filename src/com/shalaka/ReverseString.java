package com.shalaka;

public class ReverseString {
    public String reverseString(String s) {
        StringBuilder rev = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            rev.append(s.charAt(i));
        }

        return rev.toString();
    }
}
