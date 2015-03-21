package com.example.clogic.ybsi.Data;

import android.content.IntentSender;
import android.util.Log;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by we13245 on 2015-03-22.
 * PDF파일로 Export하는데 사용되는 싱글톤입니다.
 */
public class PDFMaker
{
    ///////////////////////////////////////////////////////////////////////////////////
    private static PDFMaker instance;
    public static PDFMaker getInstance()
    {
        if (instance == null)
            instance = new PDFMaker();

        return instance;
    }
    private PDFMaker()
    {
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public void exportAnswer(String path, List<Answer> answer, Font titleFont, Font dateFont, Font contentsFont) throws FileNotFoundException, DocumentException   //Answer을 PDF로 Export한다
    {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(path));
        doc.open();

        for(int i=0;i<answer.size();++i)
        {
            try
            {
                doc.add(new Paragraph(answer.get(i).question, titleFont));
                doc.add(new Paragraph(answer.get(i).date.toString(), dateFont));

                //Image img = Image.getInstance("/mnt/sdcard/DCIM/A.jpg");
                //Image img = Image.getInstance(answer.get(i).picture_path);
                //doc.add(img);

                doc.add(new Paragraph(answer.get(i).answer, contentsFont));

                doc.newPage();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        doc.close();
    }
    public String exportAnswer(List<Answer> answer) throws IOException, DocumentException   //for test
    {
        BaseFont objBaseFont = BaseFont.createFont("assets/NanumGothicBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Font titleFont = new Font(objBaseFont, 20.0f);
        Font dateFont = new Font(objBaseFont, 15.0f);
        Font contentsFont = new Font(objBaseFont);

        exportAnswer("/mnt/sdcard/test.pdf", answer, titleFont, dateFont, contentsFont);

        return "/mnt/sdcard/test.pdf";
    }

    public void UploadToGoogleDrive()
    {

    }

    public void UploadToFaceBook()
    {

    }
}
