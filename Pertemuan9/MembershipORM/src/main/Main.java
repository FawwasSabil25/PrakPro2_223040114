package main;

import javax.imageio.stream.ImageInputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;

public class Main {
    public static void main(String[] args) throws IOException{
        String resource = 'mybatis-config.xml';
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        JenisMemberDao jenisMemberDao = new JenisMemberDao(sqlSessionFactory);
        MemberDao memberDao = new MemberDao(sqlSessionFactory);
        MainFrame f = new MainFrame(jenisMemberDao, memberDao);

        javax.swing.SwingUtilities.invokeLater(() -> {
            f.setVisible(true);
        });
    }
}
