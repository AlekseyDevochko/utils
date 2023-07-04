package org.example.currency;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.xlsx.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


public class CurrencyUtil {

    public static final String D_ST_GR_J_2022_CURRENCY_XLSX = "D:\\st-gr-J2022\\currency.xlsx";
    private static String CURRENCY_URL = "https://www.nbrb.by/Services/XmlExRates.aspx";

    private final static String EMAIL_ACC = "j2022.java@rambler.ru";
    private final static String EMAIL_PWD = "2023Java";


    private final static String HOST_NAME = "smtp.rambler.ru";

    private static Document loadDocument(String url) {
        Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
            doc = factory.newDocumentBuilder().parse(new URL(url).openStream());
        } catch (ConnectException e) {
            System.err.print(" Oops! Something goes wrong! This is Belarus, baby! \nConnection timed out. ");
            System.err.print(CURRENCY_URL + " is not responsible. Please, try again later");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static List<Currency> getCurrency() {
        Document doc = loadDocument(CURRENCY_URL);
        List<Currency> curList = new ArrayList<>();

        if (doc != null) {
            NodeList nodes = doc.getFirstChild().getChildNodes();
            Node parent, child;

            for (int i = 0; i < nodes.getLength(); i++) {
                parent = nodes.item(i);

                if (parent.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childs = parent.getChildNodes();

                    List<String> listOfValues = new ArrayList<>();

                    for (int ii = 0; ii < childs.getLength(); ii++) {
                        child = childs.item(ii);
                        if (child.hasChildNodes()) {
//                            if (child.getNodeName().trim().equalsIgnoreCase("Scale") && isCurrencyCodeNext) {
//                                continue;
//                            }
                            listOfValues.add(child.getTextContent());
                        }
                    }

                    curList.add(new Currency(listOfValues.get(0), listOfValues.get(1), listOfValues.get(2), listOfValues.get(3), listOfValues.get(4)));
                }
            }
        }
        return curList;
    }

    public static void writeCurrency(List<Currency> currencies) {
        Workbook wb;
        if (D_ST_GR_J_2022_CURRENCY_XLSX.endsWith(".xlsx")) {
            wb = new XSSFWorkbook();
        } else if (D_ST_GR_J_2022_CURRENCY_XLSX.endsWith(".xls")) {
            wb = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("Incorrect format!" + D_ST_GR_J_2022_CURRENCY_XLSX + ". Expected MS Excel format");
        }


        Sheet sheet = wb.createSheet("Currency");
        int rownum = 0;
        Row date = sheet.createRow(rownum);
        date.createCell(0).setCellValue("Current Date");
        date.createCell(1).setCellValue(new Date().toString());
        rownum++;

        Row header = sheet.createRow(rownum);
        header.createCell(0).setCellValue("Num Code");
        header.createCell(1).setCellValue("Char Code");
        header.createCell(2).setCellValue("Scale");
        header.createCell(3).setCellValue("Name");
        header.createCell(4).setCellValue("Buy Rate");
        header.createCell(5).setCellValue("Sell Rate");

        for (Currency cur :
                currencies) {
            rownum++;
            Row row = sheet.createRow(rownum);
            row.createCell(0).setCellValue(cur.getNumCode());
            row.createCell(1).setCellValue(cur.getCharCode());
            row.createCell(2).setCellValue(cur.getScale());
            row.createCell(3).setCellValue(cur.getName());
            row.createCell(4).setCellValue(cur.getRateBuy());
            row.createCell(5).setCellValue(cur.getRateSell());

        }

        try (OutputStream out = new FileOutputStream(D_ST_GR_J_2022_CURRENCY_XLSX)) {
            wb.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sentExcelFile(String addressTo, String subtitle) {
//        if (!EMAIL_REGEX.equals(addressTo)) {
//            System.err.println("Incorrect email address!");
//
//        }

        Properties props = new Properties();
        props.put("mail.smtp.host", HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "465"); // 587

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_ACC, EMAIL_PWD);
                    }
                });

        //Compose the message

        File file = new File(D_ST_GR_J_2022_CURRENCY_XLSX);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_ACC));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(addressTo));
            message.setSubject(subtitle);
            message.setText("emailText");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();


            messageBodyPart.setDataHandler(new DataHandler(new FileDataSource(file)));
            messageBodyPart.setFileName("Currency");
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);


            //send the message
            Transport.send(message);
            System.out.println("message sent successfully...");


        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            file.delete();
        }
    }

    public static void sentEmailWithAttachment(String addressTo, String subtitle, String emailText, String filePath) throws MessagingException {
//        if (!EMAIL_REGEX.equals(addressTo)) {
//            System.err.println("Incorrect email address!");
//
//        }

        Properties props = new Properties();
        props.put("mail.smtp.host", HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "465"); // 587

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_ACC, EMAIL_PWD);
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_ACC));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(addressTo));
        message.setSubject(subtitle);
        message.setContent(emailText,"text/html" );

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();


        String fileName = "attachmentName";
        DataSource source = new FileDataSource(filePath);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");
    }

}


class Test {
    public static void main(String[] args) {
        CurrencyUtil.writeCurrency(CurrencyUtil.getCurrency());
        CurrencyUtil.sentExcelFile("java.tester.projects@rambler.ru", "Current Currencies");
    }
}
