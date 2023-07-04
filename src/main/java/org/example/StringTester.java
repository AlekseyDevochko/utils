package org.example;


public class StringTester {
    public static void main(String[] args) {

        String s = "abc";
        String s0 = "hello";

        String s2 = new String("abc");

        String s3 = new String();

        char[] chars = {'a', 'b', 'c'};
        String s4 = new String(chars);


        char [] chars1  = {'a', 'b', 'c', 'd', 'e', 'f' , 'g', 'h', 'i' };

        String s5 = new String(chars1, 2, 4 );

        System.out.println(s5);


        String str = "Hello World! This is very long String...";

        System.out.println(str.charAt(str.length() - 1));

        str.length();

        String str2 = " this is value  ";
        str2 = str2.trim();
        System.out.println(str2);

        str2 = str2.substring(5, 7);
        System.out.println(str2);


        String str3 = "What makes these topics problematic in terms of research?\n" +
                "Obesity\n" +
                "This is very broad. What about obesity? Causes? Effects? Relationship to other issues? Add concepts to build a topic that is a better research choice.\n" +
                "\n" +
                "Does mentoring improve the academic achievement of African American males in high school?\n" +
                "This is a fairly specific topic that includes concepts that are often researched. The topic may be fine for your paper, but you may need to remove some of the concepts when you search for articles. For example, many researchers will not limit their study to one gender, but they may include a gender breakdown in their results.\n" +
                "\n" +
                "Does maternal attachment affect the ability of future accountants to comply with Sarbanes Oxley?\n" +
                "This exact topic is probably not of interest to researchers. While there are some researchers looking at maternal attachment and others who research Sarbanes Oxley, it's extremely unlikely that research has tied the two together.\n" +
                "\n" +
                "What factors influence the growth of farmers' markets in Miami?\n" +
                "The addition of a location to this topic may result in very few results. Depending on the type of research you are doing (discussion, paper, dissertation), you may want to remove the geographic limit. Both the scope and the purpose of your research project will affect whether this topic needs to be refined.";


        String str4 = "What makes these topics problematic in terms of research?ObesityThis is very broad. What about obesity? Causes? Effects? Relationship to other issues? Add concepts to build a topic that is a better research choice.Does mentoring improve the academic achievement of African American males in high school?This is a fairly specific topic that includes concepts that are often researched. The topic may be fine for your paper, but you may need to remove some of the concepts when you search for articles. For example, many researchers will not limit their study to one gender, but they may include a gender breakdown in their results.Does maternal attachment affect the ability of future accountants to comply with Sarbanes Oxley?This exact topic is probably not of interest to researchers. While there are some researchers looking at maternal attachment and others who research Sarbanes Oxley, it's extremely unlikely that research has tied the two together.What factors influence the growth of farmers' markets in Miami?The addition of a location to this topic may result in very few results. Depending on the type of research you are doing (discussion, paper, dissertation), you may want to remove the geographic limit. Both the scope and the purpose of your research project will affect whether this topic needs to be refined.";


        char data [] = str3.toCharArray();
        data[0] = 'X';
        System.out.println(data[0] );

        System.out.println("ARRAY:");
        for (int i = 0; i< data.length; i++){
            System.out.print(data[i] + "_");
        }
        System.out.println();
        System.out.println("String:");
        for (int i = 0; i< str3.length(); i++){
            System.out.print(str3.charAt(i) + "_("+str3.codePointAt(i)+")_");

        }

        str3.endsWith("");
        str3.startsWith("");

        String first = str3.substring(0, str3.indexOf('?'));


        // Storage : Strings pool
        String s10 = "hello";
        String s20 = "hello";

        // Storage : heap
        String s30 = new String("hello");
        String s40 = new String("hello");

        String s50 = s30;

        String name = "Alex";
        int age = 35;
        System.out.println("My name is " + name + ", age is " + age);

        StringBuffer sBuffer;

        StringBuilder sBuilder = new StringBuilder(32);
        sBuilder.append(name);
        sBuilder.append( ", age is ").append(age).append("!");

        sBuilder.append(str3);

        System.out.println(sBuilder.capacity());
        System.out.println(sBuilder.length());

        String result = sBuilder.toString();

        System.out.println(sBuilder.reverse().toString());

        System.out.println("*****************************");
        System.out.println(result);

        System.out.println(result.indexOf("What"));

        int index = result.indexOf("What");
        System.out.println("begin: " + index + ", end: " + (index + "What".length()));





    }
}

