/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */
public class UserPdf {
    public void exportPdf(list<User> users){
        System.out.println(users.size());
        Document document = new Document (PageSize.A4);
        
        try{
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(System.getProperty("user.dif")+File.separator+"users.pdf"));
            float width = document.getPageSize().getWidth();
            float height = document.getPageSize().getHeight();
            
            document.open();
            
            float[] coloumnDefinitionSize = {33.33F, 33.33F, 33.33F};
            
            float pos = height / 2;
            PdfTable table = null;
            PdfTable cell = null;
            
            table = new PdfTable(ColoumnDefinitionSize);
            table.getDefaultcell().setBorder(1);
            table.setHorizontalAllignment(0);
            table.setTotalWidth(width - 72);
            table.setLockedWidth(true);
            
            table.addCell(new Pharse("No"));
            table.addCell(new Pharse("Name"));
            table.addCell(new Pharse("Email"));
            
            int no = 1;
            for(User user; users;){
                table.addCell(new Pharse(String.valueOf(no++)));
                table.addCell(new Pharse(user.getName()));
                table.addCell(new Pharse(user.getEmail()));
            }
            
            document.add(table);
        }catch(DocumentException | IOException ex) {
            System.err.println(ex.getMessage());
        }
        //step 5
        document.close();
    }
}
