package org.example;

public class StringTaskMain {

    public static void main(String[] args) {
//        String string = "I like Java!!!";
//        System.out.println(string.charAt(string.length() - 1));
//        System.out.println(string.endsWith("!!!") ? "Заканчивается !!!" : "Не заканчивается !!!");
//        System.out.println(string.startsWith("i like") ? "Начинтается с i like" : "Не начинается с i like");
//        System.out.println(string.contains("Java") ? "Содержит Java" : "Не содержит Java");
//        System.out.println(string.indexOf("Java"));
//        System.out.println(string.replace("a", "o"));
//        System.out.println(string.toUpperCase());
//        System.out.println(string.toLowerCase());
//        System.out.println(string.substring(string.indexOf("Java"), string.indexOf("Java") + 4));

//        System.out.println("**********");

//        int a = 3;
//        int b = 56;
//        int eq;
//        StringBuilder stringBuilder = new StringBuilder(100);
//        stringBuilder.append(a).append(" + ").append(b).append(" = ").append(a + b);
//        System.out.println(stringBuilder.toString());
//        eq = stringBuilder.indexOf("=");
////        stringBuilder.deleteCharAt(eq);
////        stringBuilder.insert(eq, "равно");
//        stringBuilder.replace(eq, eq + 1, "равно");
//        System.out.println(stringBuilder.toString());
//        stringBuilder.setLength(0);
//
//        stringBuilder.append(a).append(" - ").append(b).append(" = ").append(a - b);
//        System.out.println(stringBuilder.toString());
//        eq = stringBuilder.indexOf("=");
////        stringBuilder.deleteCharAt(eq);
////        stringBuilder.insert(eq, "равно");
//        stringBuilder.replace(eq, eq + 1, "равно");
//        System.out.println(stringBuilder.toString());
//        stringBuilder.setLength(0);
//
//        stringBuilder.append(a).append(" * ").append(b).append(" = ").append(a * b);
//        System.out.println(stringBuilder.toString());
//        eq = stringBuilder.indexOf("=");
////        stringBuilder.deleteCharAt(eq);
////        stringBuilder.insert(eq, "равно");
//        stringBuilder.replace(eq, eq + 1, "равно");
//        System.out.println(stringBuilder.toString());
//        stringBuilder.setLength(0);

        StringBuilder sb = new StringBuilder("Object-oriented programming is a programming language model organized around objects rather than \"actions\" and data rather than logic. Object-oriented programming blabla. Object-oriented programming bla." );
        String stringToReplace = "Object-oriented programming";
        String replaceString = "OOP";
        System.out.println(sb.toString().replaceAll(stringToReplace, replaceString));
//        int flag = 1;
//        int start = 0;
//        while (sb.substring(start, sb.length() - 1).indexOf(stringToReplace) != -1){
//            int begin = sb.substring(start, sb.length() - 1).indexOf(stringToReplace);
//            if (flag == 2){
//                sb.replace(begin, stringToReplace.length(), replaceString);
//                start += sb.indexOf(replaceString) + replaceString.length() - 1;
//
//                flag--;
//            } else {
//                start += sb.indexOf(stringToReplace) + stringToReplace.length() - 1;
//                flag++;
//            }
//        }

        System.out.println(sb.toString());




    }
}
